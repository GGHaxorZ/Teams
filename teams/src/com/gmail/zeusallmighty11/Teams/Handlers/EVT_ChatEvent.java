
package com.gmail.zeusallmighty11.Teams.Handlers;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer.Channel;



public class EVT_ChatEvent implements Listener
{
    
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        TeamPlayer t = TeamPlayer.getPlayer(e.getPlayer());
        if (t.getChatMode() == Channel.TEAM)
        {
            e.getRecipients().clear();
            e.getRecipients().add(e.getPlayer());
            for (TeamPlayer tp : t.getTeam().getMembers())
            {
                if (tp.getAsPlayer().isOnline())
                {
                    e.getRecipients().add(tp.getAsPlayer());
                }
            }
            e.setFormat("§7[" + t.getTeam().getName() + "] §3" + e.getPlayer().getName() + "§7:§r " + e.getMessage());
        }
    }
}
