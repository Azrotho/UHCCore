package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.Objects;

public class onJoin implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event){
        event.setJoinMessage("§8(§a+§8) §7" + event.getPlayer().getDisplayName());
        final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        final org.bukkit.scoreboard.Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("general", "dummy");
        objective.setDisplayName("En Attente de Partie...");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        event.getPlayer().setScoreboard(scoreboard);

        Main.getNoFall().put(event.getPlayer().getUniqueId(), false);
        Main.getStatus().put(event.getPlayer().getUniqueId(), "Wait");


        if(Main.Timer != 0 && !(Objects.equals(Main.getStatus().get(event.getPlayer().getUniqueId()), "Vivant"))){
            event.getPlayer().kickPlayer("§c§lLa partie est déjà en cours...");
        }
    }
}
