package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import fr.azrotho.uhccore.utils.checkAlive;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class HideKill implements Listener {

    @EventHandler
    public void hideKills(PlayerDeathEvent event){
        Main.getStatus().put(event.getEntity().getUniqueId(), "Mort");

        checkAlive.CheckAliveUHC();

        if(Main.getScenarios().get("HideKills")) {
            event.setDeathMessage("§fUn Joueur est mort.");
        }else{
            if(event.getEntity().getKiller() != null) {
                if (event.getEntity().getKiller().getDisplayName() != null) {
                    event.setDeathMessage("§c§l" + event.getEntity().getDisplayName() + " §f§la été tué par §c§l" + event.getEntity().getKiller().getDisplayName());
                } else {
                    event.setDeathMessage("§c§l" + event.getEntity().getDisplayName() + " §f§lest mort naturellement (PvE)");
                }
            }else{
                event.setDeathMessage("§c§l" + event.getEntity().getDisplayName() + " §f§lest mort naturellement (PvE)");
            }
        }
    }
}
