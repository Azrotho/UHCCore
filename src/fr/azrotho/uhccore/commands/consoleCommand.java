package fr.azrotho.uhccore.commands;

import fr.azrotho.uhccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class consoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            switch(strings[0]){
                case "sethost":
                    if(Bukkit.getServer().getPlayer(strings[1]).isOnline()) {
                        final UUID targetUUID = Bukkit.getServer().getPlayer(strings[1]).getUniqueId();
                        Main.getHosts().put(targetUUID, true);
                        Player targetplayer = Bukkit.getPlayer(targetUUID);
                        targetplayer.sendMessage("§a§lVous êtes devenu l'host de la partie !");
                        targetplayer.setPlayerListName("§e§lHOST | " + targetplayer.getName());
                    }else{
                        commandSender.sendMessage("§c§lCe joueur n'est pas en ligne");
                    }
                    break;
                case "help":
                    commandSender.sendMessage("§c§lhost sethost <Pseudo>: Mettre un joueur avec les permissions d'Host.");
                default:
                    commandSender.sendMessage("§c§lFaites 'console help' pour de l'aide");
            }
            return true;
        }else{
            commandSender.sendMessage("§c§lVous devez être la console pour exécuter cette commande.");
            return true;
        }
    }
}
