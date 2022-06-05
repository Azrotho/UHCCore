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
    public void OnClick(InventoryClickEvent event){
        InventoryView invview = event.getView();
        Inventory inv = event.getInventory();
        Player p = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(event.getCurrentItem() == null){
            return;
        }
        if(invview.getTitle().equalsIgnoreCase("§c§lConfiguration de la partie")){
            if(current.getItemMeta().getDisplayName().equals("§c§lGestion des Scénarios")) {
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuScenarios(p);
            }
            if(current.getItemMeta().getDisplayName().equals("§c§lGestion des Inventaires")){
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuInv(p);
            }
            if(current.getItemMeta().getDisplayName().equals("§c§lGestion des Timers")){
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuTimer(p);
            }
            if(current.getItemMeta().getDisplayName().equals("§c§lMode de Jeu")){
                event.setCancelled(true);
                p.closeInventory();
                menuHost.openMenuGamemode(p);
            }
        }
        if(invview.getTitle().equalsIgnoreCase("§c§lGestion des Scénarios")){
            if(Main.getScenarios().get(current.getItemMeta().getDisplayName())){
                Main.getScenarios().put(current.getItemMeta().getDisplayName(), false);
            }else{
                Main.getScenarios().put(current.getItemMeta().getDisplayName(), true);
            }

            event.setCancelled(true);
            p.closeInventory();
            menuHost.openMenuScenarios(p);
        }
    }
}
