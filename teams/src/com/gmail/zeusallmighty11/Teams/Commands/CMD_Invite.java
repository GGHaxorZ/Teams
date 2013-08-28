
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Invite
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
        if (tp.getTeam().getInvited().contains(args[1]))
        {
            sender.sendMessage("§8[§3Teams§8] §cThat player already has a pending invite!");
            return;
        }
        sender.sendMessage("§8[§3Teams§8] §aInvited " + args[1] + " to the team!");
        Bukkit.getServer().getPlayerExact(args[1]).sendMessage("§8[§3Teams§8] You have been invited to " + tp.getTeam().getName());
        tp.getTeam().getInvited().add(args[1]);
    }
}
