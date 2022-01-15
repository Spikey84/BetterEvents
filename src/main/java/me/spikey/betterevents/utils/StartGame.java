package me.spikey.betterevents.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class StartGame {

    public static void start(){
        for (Player p: Bukkit.getOnlinePlayers()) {
            p.sendMessage("§aEvent Started!");
            p.sendTitle("§aEvent Started!",null,1,20,1);
            if(!p.hasPermission("betterevent.spectator")||
                    !p.hasPermission("betterevent.admin")){
                p.setGameMode(GameMode.SURVIVAL);
            }


        }
        SpreadPlayers.spread();
    }




}
