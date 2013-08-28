
package com.gmail.zeusallmighty11.Teams.Handlers;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.zeusallmighty11.Teams.Teams;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class EVT_PlayerJoinEvent implements Listener
{
    
    
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if (Teams.getInstance().getPlayers().containsKey(p.getName()))
            return;
        
        TeamPlayer tp = new TeamPlayer(p.getName());
        Teams.getInstance().getPlayers().put(p.getName(), tp);
        tp.save();
    }
}
