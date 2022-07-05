package fr.azrotho.uhccore.utils;

import fr.azrotho.uhccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Timer extends BukkitRunnable {
    @Override
    public void run() {
        Main.Timer = Main.Timer + 1;
        for(Player p : Bukkit.getOnlinePlayers()) {

            final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
            final Objective objective = scoreboard.registerNewObjective("general", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(Main.Title);
            final Score Episode = objective.getScore("§c§lÉpisode: §f" + (int) (Main.Timer / 1200 + 1));
            final Score Timer = objective.getScore("§f" + ((Main.Timer - (1200 * (Main.Timer / 1200))) / 60 + " §c§lmin§f " + Main.Timer % 60));
            final Score Air = objective.getScore("");
            final Score Role = objective.getScore("§c§lPvP: §f" + Main.getTimerPvP() + " min");
            final Score Border = objective.getScore("§c§lBorder: §f" + Main.getTimerBorder() + " min");
            Episode.setScore(8);
            Timer.setScore(7);
            Air.setScore(6);
            Role.setScore(5);
            Border.setScore(4);
            p.setScoreboard(scoreboard);


            if(p.isFlying()){
                p.setFlying(false);
            }

        }
        if(Main.Timer == Main.TimerBorder * 60){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set "+ Main.BordureApres + " " + Main.TempsBordure);
            Bukkit.broadcastMessage("§c§l[!], Attention la Bordure va réduire !");
        }
        if(Main.Timer == Main.TimerPvP * 60){
            Bukkit.broadcastMessage("§c§l[!], Attention le PvP est Actif !");
        }
        if(Main.getScenarios().get("XpAsLife")){
            for(Player p : Bukkit.getOnlinePlayers()){
                p.setMaxHealth(4 + p.getLevel());
            }
        }
    }
}
