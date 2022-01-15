package me.spikey.betterevents.listeners;


import me.spikey.betterevents.Main;
import me.spikey.betterevents.kits.KitManager;
import me.spikey.betterevents.utils.KillUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {
    private KitManager kitManager;

    public KillListener(KitManager kitManager) {
        this.kitManager = kitManager;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            e.getEntity().setGameMode(GameMode.SPECTATOR);
            e.getEntity().sendTitle("§cELIMINATED!",null,1,30,1);
            if(Main.deathKick){
                e.getEntity().kickPlayer("§cEliminated from event!");
            }

    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player killer = e.getPlayer().getKiller();
        Player target = e.getPlayer();

        KillUtil.addKill(killer);
        killer.sendMessage("§aYou killed "+target.getName()+ ", you have "+ KillUtil.getKills(killer)+" kills!");

        if(KillUtil.getKills(killer)%Main.rekitPrice==0) kitManager.addKit(killer);
    }

}


