package me.spikey.betterevents.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GamemodeUtil {

    public static void gamemodeAll(GameMode g){

        for (Player p: Bukkit.getOnlinePlayers()) {
            p.setGameMode(g);
        }
    }
}
