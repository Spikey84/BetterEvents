package me.spikey.betterevents.utils;


import me.spikey.betterevents.Main;
import org.bukkit.entity.Player;

public class KillUtil {

    public static int getKills(Player p){
        Main.kills.putIfAbsent(p.getUniqueId().toString(),0);
        return  Main.kills.get(p.getUniqueId().toString());
    }
    public static void setKills(Player p,int i){
        Main.kills.put(p.getUniqueId().toString(),i);
    }


    public static void addKill(Player p){
        setKills(p,getKills(p)+1);
    }

}
