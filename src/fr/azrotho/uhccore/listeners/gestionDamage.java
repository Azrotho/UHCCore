package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
        }
    }
}
