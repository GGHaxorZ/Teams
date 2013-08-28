
package com.gmail.zeusallmighty11.Teams.TeamStuff;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;



public class TeamPlayer implements Serializable
{
    
    
    private static final long serialVersionUID = 1L;
    
    
    
    public enum Channel
    {
        GLOBAL,
        TEAM, ;
    }
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    // basic vars
    String name;
    Team team;
    Channel channel;
    transient boolean teleporting;
    transient int teleportID;
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    
    /*
     * Constructor
     */
    public TeamPlayer(String name)
    {
        this.name = name;
        this.channel = Channel.GLOBAL;
    }
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    
    /*
     * Save contents to flat file
     */
    public void save()
    {
        try
        {
            File f = new File(Teams.getInstance().getDataFolder() + "/players/" + name);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(this);
            oos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    
    
    /*
     * Sets team
     */
    public void setTeam(Team t)
    {
        this.team = t;
    }
    
    
    
    /*
     * Sets chat mode
     */
    public void setChatMode(Channel c)
    {
        this.channel = c;
    }
    
    
    
    /*
     * sets teleporting state
     */
    public void setTeleporting(boolean b)
    {
        this.teleporting = b;
    }
    
    
    
    /*
     * Initiates a safe teleport countdown and stuff
     */
    public void init_safeTeleport(final Location loc)
    {
        teleporting = true;
        teleportID = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Teams.getInstance(), new Runnable()
        {
            
            
            @Override
            public void run()
            {
                if (teleporting)
                {
                    Bukkit.getServer().getPlayerExact(name).teleport(loc);
                    teleporting = false;
                }
            }
        }, 20L * 10);
    }
    
    
    
    public void cancelTP()
    {
        Bukkit.getServer().getScheduler().cancelTask(teleportID);
    }
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    
    /*
     * Grab player statically
     */
    public static TeamPlayer getPlayer(Player p)
    {
        return Teams.getInstance().getPlayers().get(p.getName());
    }
    
    
    
    /*
     * Grab player statically
     */
    public static TeamPlayer getPlayerFromname(String s)
    {
        return Teams.getInstance().getPlayers().get(s);
    }
    
    
    
    /*
     * Grabs team or null if none
     */
    public Team getTeam()
    {
        return team;
    }
    
    
    
    /*
     * Grabs username
     */
    public String getName()
    {
        return name;
    }
    
    
    
    /*
     * Grabs chat channel
     */
    public Channel getChatMode()
    {
        return channel;
    }
    
    
    
    /*
     * Grab player object
     */
    public Player getAsPlayer()
    {
        return Bukkit.getServer().getPlayerExact(name);
    }
    
    
    
    /*
     * returns teleporting state
     */
    public boolean isTeleporting()
    {
        return teleporting;
    }
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
}
