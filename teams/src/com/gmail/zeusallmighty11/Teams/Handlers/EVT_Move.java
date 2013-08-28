
package com.gmail.zeusallmighty11.Teams.Handlers;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class EVT_Move implements Listener
{
    
    
    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        if ((int) e.getTo().getX() != (int) e.getFrom().getX() || (int) e.getTo().getY() != (int) e.getFrom().getY() || (int) e.getTo().getZ() != (int) e.getFrom().getZ())
        {
            TeamPlayer tp = TeamPlayer.getPlayer(e.getPlayer());
            if (!tp.isTeleporting())
                return;
            tp.setTeleporting(false);
            tp.cancelTP();
            e.getPlayer().sendMessage("§8[§3Teams§8] §cTeleporing cancelled!");
        }
    }
}
