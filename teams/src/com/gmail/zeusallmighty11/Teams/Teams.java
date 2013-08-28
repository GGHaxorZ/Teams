
package com.gmail.zeusallmighty11.Teams;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.zeusallmighty11.Teams.Commands.CMD_Core;
import com.gmail.zeusallmighty11.Teams.Handlers.EVT_ChatEvent;
import com.gmail.zeusallmighty11.Teams.Handlers.EVT_EntityDamageEntityEvent;
import com.gmail.zeusallmighty11.Teams.Handlers.EVT_EntityDamageEvent;
import com.gmail.zeusallmighty11.Teams.Handlers.EVT_Move;
import com.gmail.zeusallmighty11.Teams.Handlers.EVT_PlayerJoinEvent;
import com.gmail.zeusallmighty11.Teams.TeamStuff.Team;
import com.gmail.zeusallmighty11.Teams.TeamStuff.TeamPlayer;



public class Teams extends JavaPlugin
{
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    private static Teams instance;
    File rootDir;
    File teamsDir;
    File playersDir;
    Map<String, TeamPlayer> players;
    Map<String, Team> teams;
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    
    
    /*
     * (non-Javadoc)
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable()
    {
        instance = this;
        players = new HashMap<String, TeamPlayer>();
        teams = new HashMap<String, Team>();
        
        
        // directories
        rootDir = new File(getDataFolder() + "");
        if (!rootDir.exists())
            rootDir.mkdir();
        teamsDir = new File(getDataFolder() + "/teams/");
        if (!teamsDir.exists())
            teamsDir.mkdir();
        playersDir = new File(getDataFolder() + "/players/");
        if (!playersDir.exists())
            playersDir.mkdir();
        
        // register events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EVT_ChatEvent(), this);
        pm.registerEvents(new EVT_PlayerJoinEvent(), this);
        pm.registerEvents(new EVT_EntityDamageEntityEvent(), this);
        pm.registerEvents(new EVT_EntityDamageEvent(), this);
        pm.registerEvents(new EVT_Move(), this);
        
        // grab commands
        getCommand("team").setExecutor(new CMD_Core());
        
        loadTeams();
        loadPlayers();
        
        for (Player p : getServer().getOnlinePlayers())
        {
            if (!players.containsKey(p.getName()))
            {
                TeamPlayer tp = new TeamPlayer(p.getName());
                tp.save();
                players.put(p.getName(), tp);
            }
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see org.bukkit.plugin.java.JavaPlugin#onDisable()
     */
    @Override
    public void onDisable()
    {
        for (TeamPlayer tp : players.values())
            tp.save();
        for (Team t : teams.values())
            t.save();
        instance = null;
    }
    
    
    
    /*
     * Load all teams from FF
     */
    public void loadTeams()
    {
        for (File f : teamsDir.listFiles())
            try
            {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                Team t = (Team) ois.readObject();
                teams.put(t.getName(), t);
                ois.close();
            }
            catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
    }
    
    
    
    /*
     * Load all players from FF
     */
    public void loadPlayers()
    {
        for (File f : playersDir.listFiles())
            try
            {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                TeamPlayer t = (TeamPlayer) ois.readObject();
                players.put(t.getName(), t);
                ois.close();
            }
            catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
    }
    
    
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    public static Teams getInstance()
    {
        return instance;
    }
    
    
    
    public Map<String, TeamPlayer> getPlayers()
    {
        return players;
    }
    
    
    
    public Map<String, Team> getTeams()
    {
        return teams;
    }
    
    /* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
    
    
}
