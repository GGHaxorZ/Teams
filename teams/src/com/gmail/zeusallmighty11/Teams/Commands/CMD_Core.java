
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.entity.Player;



public class CMD_Core extends CMD
{
    
    
    @Override
    public void execute(Player sender, String[] args)
    {
        if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("chat") || args[0].equalsIgnoreCase("c"))
                CMD_Chat.execute(sender, args);
            if (args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("i"))
                CMD_Info.execute(sender, args);
            if (args[0].equalsIgnoreCase("sethq"))
                CMD_SetHQ.execute(sender, args);
            if (args[0].equalsIgnoreCase("setrally"))
                CMD_SetRally.execute(sender, args);
            if (args[0].equalsIgnoreCase("rally"))
                CMD_Rally.execute(sender, args);
            if (args[0].equalsIgnoreCase("hq"))
                CMD_HQ.execute(sender, args);
            if (args[0].equalsIgnoreCase("leave"))
                CMD_Leave.execute(sender, args);
            if (args[0].equalsIgnoreCase("disband"))
                CMD_Disband.execute(sender, args);
        }
        else if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("i"))
                CMD_Info.execute(sender, args);
            if (args[0].equalsIgnoreCase("promote"))
                CMD_Promote.execute(sender, args);
            if (args[0].equalsIgnoreCase("demote"))
                CMD_Demote.execute(sender, args);
            if (args[0].equalsIgnoreCase("invite"))
                CMD_Invite.execute(sender, args);
            if (args[0].equalsIgnoreCase("deinvite"))
                CMD_Deinvite.execute(sender, args);
            if (args[0].equalsIgnoreCase("kick"))
                CMD_Kick.execute(sender, args);
            if (args[0].equalsIgnoreCase("accept"))
                CMD_Accept.execute(sender, args);
            if (args[0].equalsIgnoreCase("create"))
                CMD_Create.execute(sender, args);
            if (args[0].equalsIgnoreCase("ff"))
                CMD_PVP.execute(sender, args);
        }
    }
}
