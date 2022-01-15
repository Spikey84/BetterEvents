package me.spikey.betterevents.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class WorldborderUtil {

    World w = Bukkit.getWorld("world");
    WorldBorder b = w.getWorldBorder();




    public boolean shrinkBorder(int distance, int time,int delay){
        /*
        Takes distance, time and delay input
        Broadcasts shrinking with countdown *delay* seconds before shrinking
        Distance is how much to shrink by
        Time is how long to move that distance

        Checks if border size will be valid and returns false if not valid

        uses b.setSize(b.getSize() - distance, time);
         */

        return true;
    }



}
