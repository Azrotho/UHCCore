package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class gestionDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity()).getPlayer();
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                if(Main.getNoFall().get(player.getUniqueId())){
                    event.setCancelled(true);
                }
            }
            if(Main.Timer < 30){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent event){
        if(Main.Timer < Main.TimerPvP * 60){
            if(event.getEntity() instanceof Player){
                if(event.getDamager() instanceof Player){
                    event.setCancelled(true);
                    event.getDamager().sendMessage("§c§lLe PvP n'est pas encore actif");
                }
            }
        }
    }

}
