
package com.gmail.zeusallmighty11.Teams.Handlers;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class EVT_EntityDamageEntityEvent implements Listener
{
    
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e)
    {
        if ((!(e.getEntity() instanceof Player)) || (!(e.getDamager() instanceof Player)))
            return;
        Player p = (Player) e.getEntity();
        Player damager = (Player) e.getDamager();
        TeamPlayer a = TeamPlayer.getPlayer(p);
        TeamPlayer b = TeamPlayer.getPlayer(damager);
        
        
        if (a.getTeam() != null && b.getTeam() != null)
        {
            if (a.getTeam().getName().equals(b.getTeam().getName()))
            {
                if (!a.getTeam().isPVP())
                {
                    damager.sendMessage("§8[§3Teams§8] §cYou can't hurt teammates!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
