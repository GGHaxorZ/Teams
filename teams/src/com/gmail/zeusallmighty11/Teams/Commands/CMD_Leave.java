
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Leave
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this.");
            return;
        }
        if (tp.getTeam().getOwner().equals(sender.getName()))
        {
            sender.sendMessage("§8[§3Teams§8] §cTo leave your own team, you must disband it.");
            return;
        }
        tp.getTeam().getMembers().remove(tp);
        tp.setTeam(null);
        for (TeamPlayer p : tp.getTeam().getMembers())
        {
            p.getAsPlayer().sendMessage("§8[§3Teams§8] §c" + tp.getName() + " has left the team.");
            return;
        }
        sender.sendMessage("§8[§3Teams§8] §eYou left the team.");
    }
}
