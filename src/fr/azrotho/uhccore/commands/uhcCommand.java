package fr.azrotho.uhccore.commands;

import fr.azrotho.uhccore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class uhcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        final List<String> Scenarios = Main.getScenariosList();

        switch (strings[0]) {
            case "info":
                commandSender.sendMessage("§6§lInformations de la partie:");
                commandSender.sendMessage("§e§lTitre de la partie: " + Main.Title);
                commandSender.sendMessage("§e§lMode de Jeu: " + Main.getMDJ());
                commandSender.sendMessage("§e§lActivation du PvP: §c" + Main.getTimerPvP() + " min");
                commandSender.sendMessage("§e§lActivation de la Bordure: §c" + Main.getTimerBorder() + " min");
                commandSender.sendMessage("§e§lInventaire choisit: §c" + Main.Inventory);
                commandSender.sendMessage("§e§lBordure Initale: §c" + Main.BordureAvant + " blocs");
                commandSender.sendMessage("§e§lVitesse de la Bordure: §c" + (float) (Main.BordureAvant - Main.BordureApres) / ( Main.TempsBordure * 60) + " m/s");
                commandSender.sendMessage("§e§lBordure Finale: §c" + Main.BordureApres + " blocs");
                break;
            case "scenarios":
                if(!Main.getScenarios().get("MysteryScenarios")) {
                    commandSender.sendMessage("§6§lLa liste des scénarios est:");
                    for (String scenario : Scenarios) {
                        if (Main.getScenarios().get(scenario)) {
                            commandSender.sendMessage("§e- §6" + scenario);
                        }
                    }
                }else{
                    commandSender.sendMessage("§c§lMysteryScenarios, est actif, vous ne pouvez pas avoir accès à la liste des scénarios...");

                }
                break;
        }
        return true;
    }
}
