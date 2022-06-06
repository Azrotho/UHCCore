package fr.azrotho.uhccore;

import fr.azrotho.uhccore.commands.consoleCommand;
import fr.azrotho.uhccore.commands.hostCommand;
import fr.azrotho.uhccore.commands.uhcCommand;
import fr.azrotho.uhccore.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {

    private static HashMap<String, Boolean> scenarios;

    private static HashMap<UUID, Boolean> hosts;

    private static final List<String> Scenarios = Arrays.asList("TwitchControl [X]", "HasteyBoy", "FastSmelting", "SuperHeroes", "MysteryScenarios", "HideSuccess", "HideKills", "Pride Month!");

    private static String MDJ;

    public static String Inventory;

    public static Integer TimerPvP;

    public static Integer TimerBorder;

    public static String Title;

    public static Integer Timer;

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getServer().getPluginManager().registerEvents(new inventoryClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new HideKill(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new prideMonth(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new hideSuccess(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new onJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new hasteyBoy(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new fastSmelting(), this);
        scenarios = new HashMap<>();
        hosts = new HashMap<>();
        Objects.requireNonNull(this.getCommand("uhc")).setExecutor(new uhcCommand());
        Objects.requireNonNull(this.getCommand("host")).setExecutor(new hostCommand(this));
        Objects.requireNonNull(this.getCommand("console")).setExecutor(new consoleCommand());
        for(String Scenario : Scenarios){
            scenarios.put(Scenario, false);
        }
        MDJ = "Classic";
        Inventory = "Classic";
        TimerPvP = 20;
        TimerBorder = 60;
        Title = "§c§lUHC BY AZROTHO";
        Timer = 0;
    }

    public static HashMap<String, Boolean> getScenarios() { return  scenarios; }

    public static HashMap<UUID, Boolean> getHosts() { return hosts; }

    public static List<String> getScenariosList() { return Scenarios; }

    public static String getMDJ() {
        return MDJ;
    }
    public static Integer getTimerPvP() {
        return TimerPvP;
    }

    public static Integer getTimerBorder() {
        return TimerBorder;
    }

    public static Main getInstance() {
        return INSTANCE;
    }



}
