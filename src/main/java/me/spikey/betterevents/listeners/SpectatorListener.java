package me.spikey.betterevents.listeners;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpectatorListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.SPECTATOR) {
            if (!e.getPlayer().hasPermission("betterevent.admin")) {
                World w = Bukkit.getWorld("world");
                WorldBorder b = w.getWorldBorder();
                Location l = new Location(w, b.getCenter().getBlockX(), 75, b.getCenter().getBlockZ());

                if (!isInside(e.getTo()) && e.getPlayer().getLocation().distance(b.getCenter())>b.getSize()*4) {

                    e.getPlayer().teleport(l);
                    e.getPlayer().sendMessage("§c§lYou can't go out of the worldborder");
                }
                if(e.getPlayer().getLocation().getBlockY()>300||e.getPlayer().getLocation().getBlockY()>-20){
                    e.getPlayer().teleport(l);
                    e.getPlayer().sendMessage("§c§lYou can't go far away");

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
