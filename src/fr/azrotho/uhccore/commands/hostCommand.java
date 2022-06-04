package fr.azrotho.uhccore.commands;

import fr.azrotho.uhccore.Main;
import fr.azrotho.uhccore.utils.menuHost;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hostCommand implements CommandExecutor {
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
                       Bukkit.broadcastMessage("§6§l[" + player.getName() + "] " + bc);
                        break;
                    case "menu1":
                        menuHost.openMenuHost(player);
                        break;
                    case "menu2":
                        menuHost.openMenuInv(player);
                        break;
                    case "menu3":
                        menuHost.openMenuTimer(player);
                        break;
                    case "menu4":
                        menuHost.openMenuScenarios(player);
                        break;
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
}
