package fr.azrotho.uhccore.commands;

import fr.azrotho.uhccore.Main;
import fr.azrotho.uhccore.listeners.randomizer;
import fr.azrotho.uhccore.utils.Timer;
import fr.azrotho.uhccore.utils.checkAlive;
import fr.azrotho.uhccore.utils.menuHost;
import fr.azrotho.uhccore.utils.superHeroes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class hostCommand implements CommandExecutor {

    private Main main;

    public hostCommand(Main main) { this.main = main; }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(Main.getHosts().get(player.getUniqueId())){
                switch (strings[0]){
                    case "fh":
                    case "finalheal":
                        for(Player p : Bukkit.getOnlinePlayers()){
                            p.setHealth(p.getMaxHealth());
                        }
                        Bukkit.broadcastMessage("§6§l| L'host a soigné tout le monde !");
                        break;
                    case "say":
                    case "broadcast":
                        StringBuilder bc = new StringBuilder();
                        for (String part : strings) {
                            if(!strings[0].equals(part)) {
                                bc.append(part + " ");
                            }
                        }

                        //+

                        String replaceStrings = bc.toString().replaceAll("&", "§");
                       Bukkit.broadcastMessage("§6§l[" + player.getName() + "] " + replaceStrings);
                        break;
                    case "menu":
                        if(Main.Timer == 0) {
                            menuHost.openMenuHost(player);
                        }else{
                            commandSender.sendMessage("§c§lLa partie est déjà démarré.");
                        }
                        break;
                    case "settitle":
                    case "setitle":
                    case "title":
                        StringBuilder bca = new StringBuilder();
                        for (String part : strings) {
                            if (!strings[0].equals(part)) {
                                bca.append(part + " ");
                            }
                        }
                        String replaceString = bca.toString().replaceAll("&", "§");
                        Main.Title = replaceString;
                        break;
                    case "start":
                        if(Main.Timer == 0) {
                            Timer task = new Timer();
                            task.runTaskTimer(main, 0, 20);

                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 2500");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");

                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.setHealth(20);
                                p.getInventory().clear();
                                p.setFoodLevel(20);
                                p.setSaturation(20);

                                Main.getStatus().put(p.getUniqueId(), "Vivant");
                                TPRandom(p);
                                if (Main.getScenarios().get("SuperHeroes")) {
                                    superHeroes.SuperHeroes(p);
                                }
                                if (Main.getScenarios().get("NoFall")) {
                                    Main.getNoFall().put(p.getUniqueId(), true);
                                }
                                if (Main.getScenarios().get("Random")){
                                    randomizer.randomList();
                                    p.getInventory().addItem(new ItemStack(Material.WORKBENCH, 64));
                                }
                                if (Main.getScenarios().get("AirJump")){
                                    p.setAllowFlight(true);
                                    p.setFlying(true);
                                }

                            }
                        }else{
                            commandSender.sendMessage("§cLa partie est déjà démarré !");
                        }
                        break;
                    case "silentdeath":
                        final UUID targetUUID = Bukkit.getServer().getPlayer(strings[1]).getUniqueId();
                        Main.getStatus().put(targetUUID, "Mort");
                        checkAlive.CheckAliveUHC();
                        break;
                    default:
                        player.sendMessage("§c§lCommande inconnue, faites /host help");
                }
            }else{
                player.sendMessage("§c§lVous devez être l'Host de la partie pour exécuter cette commande.");
            }
            return true;
        }else{
            commandSender.sendMessage("§c§lLa console peut pas exécuter cette commande :'c");
            return true;
        }
    }

    public void TPRandom(Player p){
        Location location = new Location(p.getWorld(), 0, 0, 0);

        location.setX(Math.random() * 1000 * 2 - 1000);
        location.setZ(Math.random() * 1000 * 2 - 1000);
        location.setY(p.getWorld().getHighestBlockAt(location.getBlockX(), location.getBlockZ()).getY() + 1);

        p.teleport(location);
    }
}