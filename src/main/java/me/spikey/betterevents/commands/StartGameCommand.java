package me.spikey.betterevents.commands;

import me.spikey.betterevents.Main;
import me.spikey.betterevents.utils.StartGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartGameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!Main.inGame) {
            StartGame.start();
            commandSender.sendMessage("§aGame started!");
            Main.inGame=true;
        }else{
            commandSender.sendMessage("§cError, game in progress");

        }
        return true;
    }
}
