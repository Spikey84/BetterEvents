package me.spikey.betterevents;

import me.spikey.betterevents.commands.LoadKitCommand;
import me.spikey.betterevents.commands.SaveKitCommand;
import me.spikey.betterevents.commands.StartGameCommand;
import me.spikey.betterevents.kits.KitManager;
import me.spikey.betterevents.listeners.JoinListener;
import me.spikey.betterevents.listeners.KillListener;
import me.spikey.betterevents.listeners.PearlListener;
import me.spikey.betterevents.listeners.SpectatorListener;
import me.spikey.betterevents.utils.StartGame;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin {
    public static ArrayList<String> spectators = new ArrayList<>();
    public static HashMap<String, Integer> kills = new HashMap<>();


    public static int rekitPrice = 3;
    public static int bordedSize = 200;
    public static int time = 12000;
    public static boolean inGame = false;
    public static boolean deathKick = false;
    public static String difficulty = "hard";

    private KitManager kitManager;



    @Override
    public void onEnable() {
        // Plugin startup logic

        this.kitManager = new KitManager(this);

        StartGame.start();

        Bukkit.getPluginManager().registerEvents(new JoinListener(kitManager),this);
        Bukkit.getPluginManager().registerEvents(new KillListener(kitManager),this);
        Bukkit.getPluginManager().registerEvents(new PearlListener(),this);
        Bukkit.getPluginManager().registerEvents(new SpectatorListener(),this);



        this.getCommand("loadkit").setExecutor(new LoadKitCommand(kitManager));
        this.getCommand("savekit").setExecutor(new SaveKitCommand(kitManager));
        this.getCommand("startgame").setExecutor(new StartGameCommand());





        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (kitManager.getKitMap() != null) {
            this.saveData();
        }
    }

    public void saveData(){
        this.getConfig().set("kit", kitManager.getKitMap());
        this.saveConfig();
    }



}
