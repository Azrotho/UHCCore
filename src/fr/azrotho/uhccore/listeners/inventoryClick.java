package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import fr.azrotho.uhccore.utils.menuHost;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

public class inventoryClick implements Listener {
    @EventHandler
    public void OnClick(InventoryClickEvent event) {
        InventoryView invview = event.getView();
        Inventory inv = event.getInventory();
        Player p = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (event.getCurrentItem() == null) {
            return;
        }
        if (invview.getTitle().equalsIgnoreCase("§c§lConfiguration de la partie")) {
            if (current.getItemMeta().getDisplayName().equals("§c§lGestion des Scénarios")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuScenarios(p);
            }
            if (current.getItemMeta().getDisplayName().equals("§c§lGestion des Inventaires")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuInv(p);
            }
            if (current.getItemMeta().getDisplayName().equals("§c§lGestion des Timers")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuTimer(p);
            }
            if (current.getItemMeta().getDisplayName().equals("§c§lMode de Jeu")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuGamemode(p);
            }
            if (current.getItemMeta().getDisplayName().equals("§c§lGestion de la Bordure")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuBorder(p);
            }
        }
        if (invview.getTitle().equalsIgnoreCase("§c§lGestion des Scénarios")) {
            if (Main.getScenarios().get(current.getItemMeta().getDisplayName())) {
                Main.getScenarios().put(current.getItemMeta().getDisplayName(), false);
            } else {
                Main.getScenarios().put(current.getItemMeta().getDisplayName(), true);
            }

            event.setCancelled(true);
            p.closeInventory();
            menuHost.openMenuScenarios(p);
        }
        if (invview.getTitle().equalsIgnoreCase("§c§lGestion des Inventaires")) {


            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lClassico")) {
                Main.Inventory = "Classic";
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lBorderline")) {
                Main.Inventory = "Borderline";
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lUHC Run")) {
                Main.Inventory = "UHC Run";
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lMeetup")) {
                Main.Inventory = "Meetup";
            }

            event.setCancelled(true);

        }

        if (invview.getTitle().equalsIgnoreCase("§c§lGestion des Timers")) {

            event.setCancelled(true);


            // PvP
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aAjouter +1 Min PvP")) {
                Main.TimerPvP = Main.TimerPvP + 1;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cRetirer -1 Min PvP")) {
                if (Main.TimerPvP != 1) {
                    Main.TimerPvP = Main.TimerPvP - 1;
                } else {
                    p.sendMessage("§c§lVous pouvez pas mettre le Timer à 0.");
                }
            }

            // Bordure
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aAjouter +1 Min Bordure")) {
                Main.TimerBorder = Main.TimerBorder + 1;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cRetirer -1 Min Bordure")) {
                if (Main.TimerBorder != 1) {
                    Main.TimerBorder = Main.TimerBorder - 1;
                } else {
                    p.sendMessage("§c§lVous pouvez pas mettre le Timer à 0.");
                }
            }

            p.closeInventory();
            menuHost.openMenuTimer(p);

        }

        if (invview.getTitle().equalsIgnoreCase("§c§lGestion de la Bordure")) {

            event.setCancelled(true);


            // Bordure Avant
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aAjouter +50 Bloc Avant")) {
                Main.BordureAvant = Main.BordureAvant + 50;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cRetirer -50 Bloc Avant")) {
                if (Main.BordureAvant != 50) {
                    Main.BordureAvant = Main.BordureAvant - 50;
                } else {
                    p.sendMessage("§c§lVous ne pouvez pas faire une bordure plus petite que 50.");
                }
            }

            // Bordure Après
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aAjouter +50 Bloc Après")) {
                Main.BordureApres = Main.BordureApres + 50;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cRetirer -50 Bloc Après")) {
                if (Main.BordureApres != 50) {
                    Main.BordureApres = Main.BordureApres - 50;
                } else {
                    p.sendMessage("§c§lVous ne pouvez pas faire une bordure plus petite que 50.");
                }
            }


            // Temps Bordure
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§aAjouter +1 Min")) {
                Main.TempsBordure = Main.TempsBordure + 1;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cRetirer -1 Min")) {
                if (Main.TempsBordure != 1) {
                    Main.TempsBordure = Main.TempsBordure - 1;
                } else {
                    p.sendMessage("§c§lVous pouvez pas mettre le Timer à 0.");
                }

            }
            p.closeInventory();
            menuHost.openMenuBorder(p);
        }
    }
}
