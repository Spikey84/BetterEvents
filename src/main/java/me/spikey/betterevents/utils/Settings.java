package me.spikey.betterevents.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;

public class Settings {

    public static void startServer(){
        World w = Bukkit.getWorld("world");
        w.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        w.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        w.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        w.setGameRule(GameRule.DO_ENTITY_DROPS, false);
        w.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, false);
        w.setGameRule(GameRule.DO_FIRE_TICK, true);
        w.setGameRule(GameRule.DO_TILE_DROPS, false);
        w.setGameRule(GameRule.SPAWN_RADIUS, 0);
        w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false);
        w.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        w.setGameRule(GameRule.NATURAL_REGENERATION, true);
        w.setTime(12000);
        w.setPVP(false);
      //  SpigotConfig.whitelistMessage = "§cNo event is currently running! (Whitelisted)";
     //   SpigotConfig.serverFullMessage = "§cThe server is currently full! (Stay in queue to rejoin)";

    }
    public static void startGame(){
        World w = Bukkit.getWorld("world");
        w.setPVP(true);
     //   SpigotConfig.whitelistMessage = "§cNo event is currently running! (Whitelisted)";
      //  SpigotConfig.serverFullMessage = "§cThe server is currently full! (Stay in queue to rejoin)";



    }


}
