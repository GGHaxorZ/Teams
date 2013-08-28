
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer.Channel;



public class CMD_Chat
{
    
    
    public static void execute(Player sender, String[] args)
    {
        TeamPlayer tp = TeamPlayer.getPlayer(sender);
        
        if (tp.getTeam() == null)
        {
            sender.sendMessage("§8[§3Teams§8] §cYou need a team to do this!");
            return;
        }
        
        if (tp.getChatMode() == Channel.GLOBAL)
        {
            tp.setChatMode(Channel.TEAM);
            sender.sendMessage("§8[§3Teams§8] §eChat mode set to team!");
        }
        else
        {
            tp.setChatMode(Channel.GLOBAL);
            sender.sendMessage("§8[§3Teams§8] §eChat mode set to global!");
        }
    }
    
}
