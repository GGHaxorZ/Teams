
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;
import com.gmail.zeusallmighty11.Teams.TeamStuff.Team;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class CMD_Info
{
    
    
    public static void execute(Player sender, String[] args)
    {
        if (args.length == 1)
        {
            TeamPlayer tp = TeamPlayer.getPlayer(sender);
            if (tp.getTeam() == null)
            {
                sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this.");
                return;
            }
            Team team = tp.getTeam();
            sender.sendMessage("§8[§3Teams§8] §eTeam: §r" + team.getName());
            sender.sendMessage("§8[§3Teams§8] §eOwner: §r" + team.getOwner());
            
            StringBuilder pp = new StringBuilder();
            for (String abc : team.getPromoted())
                pp.append(abc).append(" ");
            sender.sendMessage("§8[§3Teams§8] §ePromoted Players: §r" + pp.toString());
            
            StringBuilder mem = new StringBuilder();
            for (TeamPlayer abc : team.getMembers())
                mem.append(abc.getName()).append(" ");
            sender.sendMessage("§8[§3Teams§8] §eMembers: §r" + mem.toString());
            
            StringBuilder ip = new StringBuilder();
            for (String abc : team.getInvited())
                ip.append(abc).append(" ");
            sender.sendMessage("§8[§3Teams§8] §eInvited Players: §r" + ip.toString());
            
            return;
        }
        if (args.length >= 2)
        {
            for (TeamPlayer tp : Teams.getInstance().getPlayers().values())
            {
                if (!args[1].equals(tp.getName()))
                    continue;
                Team team = tp.getTeam();
                
                if (tp.getTeam() == null)
                {
                    sender.sendMessage("§8[§3Teams§8] §cThat player has no team.");
                    return;
                }
                
                sender.sendMessage("§8[§3Teams§8] §eTeam: §r" + tp.getTeam().getName());
                sender.sendMessage("§8[§3Teams§8] §eOwner: §r" + team.getOwner());
                StringBuilder pp = new StringBuilder();
                for (String abc : team.getPromoted())
                    pp.append(abc).append(" ");
                sender.sendMessage("§8[§3Teams§8] §ePromoted Players: §r" + pp.toString());
                
                StringBuilder mem = new StringBuilder();
                for (TeamPlayer abc : team.getMembers())
                    mem.append(abc.getName()).append(" ");
                sender.sendMessage("§8[§3Teams§8] §eMembers: §r" + mem.toString());
                
                StringBuilder ip = new StringBuilder();
                for (String abc : team.getInvited())
                    ip.append(abc).append(" ");
                sender.sendMessage("§8[§3Teams§8] §eInvited Players: §r" + ip.toString());
                return;
            }
        }
    }
}
