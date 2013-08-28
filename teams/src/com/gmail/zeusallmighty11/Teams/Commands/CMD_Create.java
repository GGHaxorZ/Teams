
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;
import com.gmail.zeusallmighty11.Teams.TeamStuff.Team;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Create
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() != null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou already have a team!");
            return;
        }
        Team team = new Team(args[1], sender.getName());
        tp.setTeam(team);
        Teams.getInstance().getTeams().put(team.getName(), team);
        team.getPromoted().add(sender.getName());
        team.getMembers().add(tp);
        sender.sendMessage("§8[§3Teams§8] §aTeam \"" + args[1] + "\" created.");
    }
}
