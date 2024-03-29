package fr.azrotho.uhccore;

import fr.azrotho.uhccore.commands.consoleCommand;
import fr.azrotho.uhccore.commands.hostCommand;
import fr.azrotho.uhccore.commands.uhcCommand;
import fr.azrotho.uhccore.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {

    private static HashMap<String, Boolean> scenarios;
    private static HashMap<UUID, Boolean> hosts;
    private static final List<String> Scenarios = Arrays.asList("TwitchControl [WIP]", "HasteyBoy", "FastSmelting", "SuperHeroes", "MysteryScenarios", "HideKills", "Pride Month!", "Random", "AirJump", "KickAtDeath", "NoFall", "XpAsLife");
    private static String MDJ;
    public static String Inventory;
    public static Integer TimerPvP;
    public static Integer TimerBorder;
    public static String Title;
    public static Integer Timer;
    public static Main INSTANCE;
    private static HashMap<UUID, Boolean> NoFall;
    private static HashMap<UUID, String> Status;
    private static HashMap<Material, Material> Random;
    public static Integer BordureAvant;
    public static Integer BordureApres;
    public static Integer TempsBordure;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getServer().getPluginManager().registerEvents(new gestionDamage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new inventoryClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new HideKill(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new prideMonth(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new hideSuccess(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new onJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new hasteyBoy(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new fastSmelting(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new randomizer(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new doubleJump(), this);
        scenarios = new HashMap<>();
        hosts = new HashMap<>();
        NoFall = new HashMap<>();
        Status = new HashMap<>();
        Random = new HashMap<>();
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
        Title = "§c§lUHC CORE";
        Timer = 0;
        BordureAvant = 1250;
        BordureApres = 100;
        TempsBordure = 5;
    }

    public static HashMap<String, Boolean> getScenarios() { return  scenarios; }
    public static HashMap<UUID, Boolean> getHosts() { return hosts; }
    public static List<String> getScenariosList() { return Scenarios; }
    public static HashMap<Material, Material> getRandom() { return Random; }
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
    public static HashMap<UUID, Boolean> getNoFall() { return NoFall; }
    public static HashMap<UUID, String> getStatus() { return Status; }
}