
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Kick
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this.");
            return;
        }
        if (!tp.getTeam().getPromoted().contains(sender.getName()))
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need to be a higher rank to do this!");
            return;
        }
        tp.getTeam().getMembers().remove(TeamPlayer.getPlayerFromname(args[1]));
        sender.sendMessage("§8[§3Teams§8] §eYou kicked " + args[1] + " from the team.");
        for (TeamPlayer abc : tp.getTeam().getMembers())
        {
            if (abc.getAsPlayer().isOnline())
            {
                abc.getAsPlayer().sendMessage("§8[§3Teams§8] §c" + args[1] + " was kicked from the team.");
            }
        }
        return;
    }
}
