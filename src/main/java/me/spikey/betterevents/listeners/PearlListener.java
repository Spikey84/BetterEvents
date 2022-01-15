package me.spikey.betterevents.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PearlListener implements Listener {

    @EventHandler
    public void onPearl (PlayerTeleportEvent e){

        if (e.getCause()== PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            if(isInside(e.getFrom())&&!isInside(e.getTo())){
                e.setCancelled(true);
                e.getPlayer().sendMessage("§c§lYou can't pearl out of the worldborder!");
            } else {
                World w = Bukkit.getWorld("world");
                WorldBorder b = w.getWorldBorder();
                if(!isInside(e.getFrom())&&!isInside(e.getTo())){
                    if(e.getFrom().distance(b.getCenter())+50<e.getTo().distance(b.getCenter())){
                        e.setCancelled(true);
                        e.getPlayer().sendMessage("§c§lYou can't pearl out of the worldborder!");
                    }
                }
            }


        }
    }

    public boolean isInside(Location l){

        World w = Bukkit.getWorld("world");
        WorldBorder b = w.getWorldBorder();
        return b.isInside(l);
    }





}
