package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class prideMonth implements Listener {
    @EventHandler
    public void pride(EntitySpawnEvent event) {
        if (Main.getScenarios().get("Pride Month!")) {
            if (event.getEntity().getType() == EntityType.SHEEP) {
                event.getEntity().setCustomName("jeb_");
            }
        }
    }
}
