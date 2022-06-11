package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class doubleJump implements Listener {

    Plugin plugin = Main.getInstance();


    @EventHandler
    public void setVelocity(PlayerToggleFlightEvent e) {
        if(Main.getScenarios().get("AirJump")){

        Player p = e.getPlayer();


            e.setCancelled(true);

            p.setAllowFlight(false);
            p.setFlying(false);

            p.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.5).setY(1));

            giveFlight(p, 20);

            p.setAllowFlight(false);
        }

    }

    private void giveFlight(Player p, int delay) {

        new BukkitRunnable() {

            @Override
            public void run() {

                p.setAllowFlight(true);

            }

        }.runTaskLater(plugin, delay);

    }
}
