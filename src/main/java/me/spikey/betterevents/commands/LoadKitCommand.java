package me.spikey.betterevents.commands;

import me.spikey.betterevents.kits.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoadKitCommand implements CommandExecutor {
    private KitManager kitManager;

    public LoadKitCommand(KitManager kitManager) {

        this.kitManager = kitManager;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length==0){
            if(commandSender instanceof Player){
                Player p = (Player) commandSender;
                kitManager.givekit(p);
            }
            else{
                commandSender.sendMessage("§cYou must target a player");
            }

        } else {

            Player target = Bukkit.getPlayerExact(strings[0]);
            kitManager.givekit(target);
            commandSender.sendMessage("§aKit loaded for "+target.getName());

        }



        return true;
    }
}
