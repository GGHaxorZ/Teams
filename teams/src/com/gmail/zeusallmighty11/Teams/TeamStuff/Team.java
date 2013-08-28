
package com.gmail.zeusallmighty11.Teams.TeamStuff;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.gmail.zeusallmighty11.Teams.Teams;



public class Team implements Serializable
{
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    private static final long serialVersionUID = 1L;
    
    // basic info
    String name;
    String owner;
    String info;
    
    // home location
    double x;
    double y;
    double z;
    float pitch;
    float yaw;
    String world;
    
    // rally location
    double x1;
    double y1;
    double z1;
    float pitch1;
    float yaw1;
    String world1;
    
    // promoted players
    Set<String> promoted;
    
    // invited players (waiting)
    Set<String> invited;
    
    // members
    Set<TeamPlayer> members;
    
    // pvp ?
    boolean pvp;
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    /*
     * Constructor
     */
    public Team(String name, String owner)
    {
        this.name = name;
        this.owner = owner;
        this.promoted = new HashSet<String>();
        this.invited = new HashSet<String>();
        this.members = new HashSet<TeamPlayer>();
    }
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    /*
     * Save contents to flat file
     */
    public void save()
    {
        try
        {
            File f = new File(Teams.getInstance().getDataFolder() + "/teams/" + name);
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
     * Promote specified player
     */
    public void promotePlayer(Player p)
    {
        promoted.add(p.getName());
    }
    
    
    
    /*
     * Demote specified player
     */
    public void demotePlayer(Player p)
    {
        promoted.remove(p.getName());
    }
    
    
    
    /*
     * Invite specified player
     */
    public void invitePlayer(Player p)
    {
        invited.add(p.getName());
    }
    
    
    
    /*
     * Deinvite specified player
     */
    public void deinvitePlayer(Player p)
    {
        invited.remove(p.getName());
    }
    
    
    
    /*
     * Sets HQ Location
     */
    public void setHQ(Location loc)
    {
        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();
        this.pitch = loc.getPitch();
        this.yaw = loc.getYaw();
        this.world = loc.getWorld().getName();
    }
    
    
    
    /*
     * Sets rally location
     */
    public void setRally(Location loc)
    {
        this.x1 = loc.getX();
        this.y1 = loc.getY();
        this.z1 = loc.getZ();
        this.pitch1 = loc.getPitch();
        this.yaw1 = loc.getYaw();
        this.world1 = loc.getWorld().getName();
    }
    
    
    
    /*
     * Toggles pvp
     */
    public void setPVP(boolean b)
    {
        this.pvp = b;
    }
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    /*
     * Grabs name of team
     */
    public String getName()
    {
        return name;
    }
    
    
    
    /*
     * Grab team owner's name
     */
    public String getOwner()
    {
        return owner;
    }
    
    
    
    /*
     * Grab owner as a player
     */
    public Player getOwnerAsPlayer()
    {
        return Bukkit.getServer().getPlayerExact(owner);
    }
    
    
    
    /*
     * Grabs description
     */
    public String getInfo()
    {
        return info;
    }
    
    
    
    /*
     * Grabs HQ location
     */
    public Location getHQ()
    {
        Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
        loc.setPitch(pitch);
        loc.setYaw(yaw);
        return loc;
    }
    
    
    
    /*
     * Grabs rally location
     */
    public Location getRally()
    {
        Location loc = new Location(Bukkit.getServer().getWorld(world1 != null ? world1 : "world"), x1, y1, z1);
        loc.setPitch(pitch1);
        loc.setYaw(yaw1);
        return loc;
    }
    
    
    
    /*
     * Grabs invited
     */
    public Set<String> getInvited()
    {
        return invited;
    }
    
    
    
    /*
     * Grabs promoted
     */
    public Set<String> getPromoted()
    {
        return promoted;
    }
    
    
    
    /*
     * Grab set of all members
     */
    public Set<TeamPlayer> getMembers()
    {
        return members;
    }
    
    
    
    /*
     * returns state of pvp
     */
    public boolean isPVP()
    {
        return pvp;
    }
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
}
