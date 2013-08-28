
package com.gmail.zeusallmighty11.Teams.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public abstract class CMD implements CommandExecutor
{
    
    
    @Override
    public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] args)
    {
        if (args.length < 1)
        {
            cs.sendMessage(" \n \n \n ");
            cs.sendMessage("§8==============================================");
            cs.sendMessage("§8[§3teams§8] §3/team §eaccept §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §echat");
            cs.sendMessage("§8[§3teams§8] §3/team §edeinvite §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §edemote §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §ehq");
            cs.sendMessage("§8[§3teams§8] §3/team §einfo");
            cs.sendMessage("§8[§3teams§8] §3/team §einvite §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §ekick §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §eleave");
            cs.sendMessage("§8[§3teams§8] §3/team §epromote §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §erally");
            cs.sendMessage("§8[§3teams§8] §3/team §esethq");
            cs.sendMessage("§8[§3teams§8] §3/team §esetrally");
            cs.sendMessage("§8[§3teams§8] §3/team §ecreate §7[name]");
            cs.sendMessage("§8[§3teams§8] §3/team §einfo §7[info]");
            cs.sendMessage("§8[§3teams§8] §3/team §4disband");
            cs.sendMessage("§8==============================================");
            cs.sendMessage("§8[§3teams§8] §cInvalid command.");
            return false;
        }
        execute((Player) cs, args);
        return false;
    }
    
    
    
    public abstract void execute(Player sender, String[] args);
    
}
