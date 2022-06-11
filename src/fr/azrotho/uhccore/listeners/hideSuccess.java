package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;


public class hideSuccess implements Listener {

    @EventHandler
    public void HideSuccess(PlayerAchievementAwardedEvent event){
            event.setCancelled(true);
    }
}
