package me.spikey.betterevents.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;


public class SpreadPlayers {


    public static void spread() {


        for (Player p : Bukkit.getOnlinePlayers()) {
            if(!p.hasPermission("betterevent.spectator")||
                    !p.hasPermission("betterevent.admin")) {
                p.teleport(getSafeLocation());
            }
        }
    }
    public static Location getSafeLocation(){

        World w = Bukkit.getWorld("world");
        WorldBorder b = w.getWorldBorder();

        int maxX = (int)(b.getSize()/2)-10;
        int maxZ = (int)(b.getSize()/2)-10;
        int centerX = b.getCenter().getBlockX();
        int centerZ = b.getCenter().getBlockZ();

        int x = centerX-(int)(Math.random()*maxX);
        int z = centerZ-(int)(Math.random()*maxZ);
        int sign;
        int count = 0;

        while(!w.getHighestBlockAt(x,z).getType().isOccluding()){
            if(Math.random()>0.5){
                sign=1;
            }else{
                sign=-1;
            }
            x = centerX-(int)(Math.random()*maxX)*sign;

            if(Math.random()>0.5){
                sign=1;
            }else{
                sign=-1;
            }

            z = centerZ-(int)(Math.random()*maxZ)*sign;

            count++;
            if(count>50){
                return w.getHighestBlockAt(b.getCenter()).getLocation().add(0,2,0);
            }


        }


        return w.getHighestBlockAt(x,z).getLocation().add(0,1,0);
    }
}
