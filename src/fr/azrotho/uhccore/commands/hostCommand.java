package fr.azrotho.uhccore.commands;

import fr.azrotho.uhccore.Main;
import fr.azrotho.uhccore.utils.Timer;
import fr.azrotho.uhccore.utils.menuHost;
import fr.azrotho.uhccore.utils.superHeroes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                        String replaceStrings = bc.toString().replaceAll("&", "§");
                       Bukkit.broadcastMessage("§6§l[" + player.getName() + "] " + replaceStrings);
                        break;
                    case "menu":
                        menuHost.openMenuHost(player);
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
                        Timer task = new Timer();
                        task.runTaskTimer(main, 0, 20);
                        for(Player p : Bukkit.getOnlinePlayers()) {
                            p.setHealth(20);
                            p.getInventory().clear();
                            p.setFoodLevel(20);
                            p.setSaturation(20);
                            TPRandom(p);
                            if(Main.getScenarios().get("SuperHeroes")){
                                superHeroes.SuperHeroes(p);
                            }
                        }

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
