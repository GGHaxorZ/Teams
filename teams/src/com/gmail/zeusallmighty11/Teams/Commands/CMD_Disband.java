
package com.gmail.zeusallmighty11.Teams.Commands;


import java.io.File;

import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Disband
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this.");
            return;
        }
        if (!tp.getTeam().getOwner().equals(sender.getName()))
        {
            sender.sendMessage("§8[§3Teams§8] §cOnly the owner can disband a team.");
            return;
        }
        Teams.getInstance().getTeams().remove(tp.getTeam().getName());
        tp.getTeam().getPromoted().clear();
        tp.getTeam().getInvited().clear();
        File f = new File(Teams.getInstance().getDataFolder() + "/teams/" + tp.getTeam().getName());
        f.delete();
        for (TeamPlayer ttt : tp.getTeam().getMembers())
        {
            ttt.setTeam(null);
            if (ttt.getAsPlayer().isOnline())
                ttt.getAsPlayer().sendMessage("§8[§3Teams§8] §eTeam disbanded.");
        }
    }
}
