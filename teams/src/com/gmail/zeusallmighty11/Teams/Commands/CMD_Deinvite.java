
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Deinvite
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
        if (!tp.getTeam().getInvited().contains(args[1]))
        {
            sender.sendMessage("§8[§3Teams§8] §cThat player does not have a pending invite.");
            return;
        }
        sender.sendMessage("§8[§3Teams§8] §eCancelled invite for " + args[1]);
        tp.getTeam().getInvited().remove(args[1]);
    }
}
