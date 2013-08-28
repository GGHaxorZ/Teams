
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_SetRally
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
        tp.getTeam().setRally(sender.getLocation());
        sender.sendMessage("§8[§3Teams§8] §aRally Location set.");
        for (TeamPlayer tpp : tp.getTeam().getMembers())
            if (tpp.getAsPlayer().isOnline())
                tpp.getAsPlayer().sendMessage("§8[§3Teams§8] Rally home has been set");
    }
}
