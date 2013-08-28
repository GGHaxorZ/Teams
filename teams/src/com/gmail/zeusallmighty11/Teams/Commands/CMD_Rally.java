
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Rally
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this.");
            return;
        }
        if (tp.getTeam().getRally().getWorld() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cThere is no valid Rally location.");
            return;
        }
        boolean wait = false;
        for (Entity e : sender.getNearbyEntities(30.0, 30.0, 30.0))
        {
            if (!(e instanceof Player))
                continue;
            wait = true;
            Player p = (Player) e;
            if (TeamPlayer.getPlayer(p).getTeam() == null || !TeamPlayer.getPlayer(p).getTeam().getName().equals(tp.getTeam().getName()))
            {
                tp.init_safeTeleport(tp.getTeam().getRally());
                sender.sendMessage("§8[§3Teams§8] §7Please wait 10 seconds. Taking damage or moving will cancel the teleport.");
                return;
            }
        }
        if (!wait)
        {
            tp.getAsPlayer().teleport(tp.getTeam().getRally());
            sender.sendMessage("§8[§3Teams§8] §aTeleported to rally location.");
        }
    }
}
