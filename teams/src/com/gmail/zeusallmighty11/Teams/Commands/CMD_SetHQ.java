
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_SetHQ
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
        tp.getTeam().setHQ(sender.getLocation());
        sender.sendMessage("§8[§3Teams§8] §aHQ Location set.");
        for (TeamPlayer tpp : tp.getTeam().getMembers())
            if (tpp.getAsPlayer().isOnline())
                tpp.getAsPlayer().sendMessage("§8[§3Teams§8] HQ has been set");
    }
}
