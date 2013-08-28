
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;
import com.gmail.zeusallmighty11.Teams.TeamStuff.Team;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Accept
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        if (tp.getTeam() != null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou must leave a team before you can join another!");
            return;
        }
        for (Team t : Teams.getInstance().getTeams().values())
        {
            if (t.getName().equals(args[1]))
            {
                if (!t.getInvited().contains(sender.getName()))
                {
                    sender.sendMessage("§8[§3Teams§8] §cYou must be invited to this team!");
                    return;
                }
                t.getInvited().remove(sender.getName());
                tp.setTeam(t);
                t.getMembers().add(tp);
                sender.sendMessage("§8[§3Teams§8] §aYou joined " + args[1] + "!");
            }
        }
    }
    
}
