package me.spikey.betterevents.commands;

import me.spikey.betterevents.kits.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveKitCommand implements CommandExecutor {
    private KitManager kitManager;

    public SaveKitCommand(KitManager kitManager) {
        this.kitManager = kitManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            kitManager.saveKit(p);
        }
        else {
            commandSender.sendMessage("§cOnly players can do this!");
        }

        return true;
    }
}
