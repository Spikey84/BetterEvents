package me.spikey.betterevents.kits;

import me.spikey.betterevents.Main;
import me.spikey.betterevents.utils.YMLUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class KitManager {

    private HashMap<String, Integer> kits = new HashMap<>();
    private boolean kitOnJoin = true;
    private ItemStack[] kit = new ItemStack[41];
    private int defaultKits = 3;

    public KitManager(Plugin plugin) {
        File kitFile = new File(plugin.getDataFolder() + "/kit.yml");
        FileConfiguration kitConfig = YamlConfiguration.loadConfiguration(kitFile);
        //if (kitConfig == null) {
            File tmpKitFolder = new File(getClass().getResource("kit.yml").getFile());
            FileConfiguration tmpKit = YamlConfiguration.loadConfiguration(tmpKitFolder);
            YMLUtils.saveCustomYml(tmpKit, kitFile);
            kitConfig = YamlConfiguration.loadConfiguration(kitFile);
        //}
        kit = ((List<ItemStack>) kitConfig.get("kit")).toArray(new ItemStack[0]);
    }




    public int getKits(Player p){
        kits.putIfAbsent(p.getUniqueId().toString(),0);
        return  kits.get(p.getUniqueId().toString());
    }

    public void setKits(Player p,int i){
        kits.put(p.getUniqueId().toString(),i);
    }


    public void addKit  (Player p){
        setKits(p,getKits(p)+1);
        p.sendMessage("§a§lYou gained a rekit!");

    }
    public void removeKit  (Player p){
        setKits(p,getKits(p)-1);
    }


    public void saveKit(Player p){

        kit = p.getInventory().getContents();
        p.sendMessage("§aKit Saved!");
    }

    public void givekit (Player p){

        p.getInventory().setContents(kit);
        p.sendMessage("§aKit Loaded!");

    }

    public void kitAll() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            givekit(p);
        }
    }


    public void reKit(Player p){

        if(getKits(p)>0){
            removeKit(p);
            givekit(p);
            p.sendMessage("§aKit Loaded! You have "+getKits(p)+" rekits remaining!");

        }else {
            p.sendMessage("§cError, no rekits left!");
        }
    }

    public HashMap<String, Integer> getKitMap() {
        return kits;
    }


    public int getDefaultKits() {
        return defaultKits;
    }
}
