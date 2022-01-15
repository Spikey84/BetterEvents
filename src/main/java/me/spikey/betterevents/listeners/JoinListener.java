package me.spikey.betterevents.listeners;

import me.spikey.betterevents.Main;
import me.spikey.betterevents.kits.KitManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private KitManager kitManager;

    public JoinListener(KitManager kitManager) {
        this.kitManager = kitManager;
    }

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e){

        if(Main.inGame){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            e.getPlayer().sendMessage("§c§lAn event is in progress, you have been placed in spectator");
        }else {
            Player p = e.getPlayer();
            String uuid = p.getUniqueId().toString();
            String name = p.getName();
            Main.kills.putIfAbsent(uuid, 0);
            kitManager.getKitMap().putIfAbsent(uuid, kitManager.getDefaultKits());
            if (p.hasPermission("betterevent.spectator")) {
                p.setGameMode(GameMode.SPECTATOR);
            }
            if (p.hasPermission("betterevent.admin")) {
                p.setGameMode(GameMode.CREATIVE);
            } else {
                p.setGameMode(GameMode.ADVENTURE);
            }
        }



        }
}
