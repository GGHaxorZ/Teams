
package com.gmail.zeusallmighty11.Teams.Handlers;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class EVT_EntityDamageEvent implements Listener
{
    
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e)
    {
        if (!(e.getEntity() instanceof Player))
            return;
        Player p = (Player) e.getEntity();
        
        if (TeamPlayer.getPlayer(p).isTeleporting())
        {
            if (!e.isCancelled())
            {
                TeamPlayer.getPlayer(p).setTeleporting(false);
                TeamPlayer.getPlayer(p).cancelTP();
                p.sendMessage("§8[§3Teams§8] §cTeleporing cancelled!");
            }
        }
    }
}
