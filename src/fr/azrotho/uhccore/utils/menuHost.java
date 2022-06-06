package fr.azrotho.uhccore.utils;

import fr.azrotho.uhccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import java.util.Arrays;
import java.util.List;

public class menuHost {

    private static final List<String> Scenarios = Main.getScenariosList();


    public static void openMenuHost(Player p){
        Inventory inv = Bukkit.createInventory(null, 45, "§c§lConfiguration de la partie");
        p.openInventory(inv);

        inv.setItem(19, itemConstructor.getItem(Material.REDSTONE, "§c§lGestion des Scénarios", false, 1));
        inv.setItem(21, itemConstructor.getItem(Material.LEATHER_CHESTPLATE, "§c§lGestion des Inventaires", false, 1));
        inv.setItem(23, itemConstructor.getItem(Material.PAPER, "§c§lMode de Jeu", false, 1));
        inv.setItem(25, itemConstructor.getItem(Material.BEACON, "§c§lGestion des Timers", false, 1));
        inv.setItem(29, itemConstructor.getItem(Material.DIAMOND_BLOCK, "Gestion de la Bordure", false, 1));

    }
    public static void openMenuScenarios(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, "§c§lGestion des Scénarios");
        p.openInventory(inv);
        ItemStack wool;
        for(String Scenario : Scenarios){

            if(Main.getScenarios().get(Scenario)){
                wool = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
            }else{
                wool = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
            }
            ItemMeta ScItem = wool.getItemMeta();
            ScItem.setDisplayName(Scenario);
            wool.setItemMeta(ScItem);
            inv.addItem(wool);
        }
    }
    public static void openMenuInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, "§c§lGestion des Inventaires");

        p.openInventory(inv);

        inv.setItem(19, itemConstructor.getItem(Material.WOOD_PICKAXE, "§c§lClassico", false, 1));
        inv.setItem(29, itemConstructor.getItem(Material.TNT, "§c§lBorderline", false, 1));
        inv.setItem(21, itemConstructor.getItem(Material.IRON_PICKAXE, "§c§lUHC Run", true, 1));
        inv.setItem(31, itemConstructor.getItem(Material.DIAMOND_SPADE, "§c§lMeetup", true, 1));

    }

    public static void openMenuTimer(Player p){
       Inventory inv = Bukkit.createInventory(null, 45, "§c§lGestion des Timers");

       p.openInventory(inv);

       ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
       ItemMeta pvpMeta = pvp.getItemMeta();
       pvpMeta.setDisplayName("§c§lTimer du PvP");
       pvpMeta.setLore(Arrays.asList(" ", "§cActivation du PvP: §e" + Main.getTimerPvP() + "§cmin"));
       pvp.setItemMeta(pvpMeta);
       inv.setItem(20, pvp);

        ItemStack Border = new ItemStack(Material.IRON_BLOCK);
        ItemMeta BorderMeta = pvp.getItemMeta();
        BorderMeta.setDisplayName("§c§lTimer de la Bordure");
        BorderMeta.setLore(Arrays.asList(" ", "§cActivation de la Bordure: §e" + Main.getTimerBorder() + "§cmin"));
        Border.setItemMeta(BorderMeta);
        inv.setItem(24, Border);

        ItemStack AddPvP = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.LIME.getData());
        ItemMeta AddPvPMeta = AddPvP.getItemMeta();
        AddPvPMeta.setDisplayName("§aAjouter +1 Min PvP");
        AddPvP.setItemMeta(AddPvPMeta);
        inv.setItem(11, AddPvP);

        ItemStack RemovePvP = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.RED.getData());
        ItemMeta RemovePvPMeta = RemovePvP.getItemMeta();
        RemovePvPMeta.setDisplayName("§cRetirer -1 Min PvP");
        RemovePvP.setItemMeta(RemovePvPMeta);
        inv.setItem(29, RemovePvP);

        ItemStack AddBordure = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.LIME.getData());
        ItemMeta AddBordureMeta = AddBordure.getItemMeta();
        AddBordureMeta.setDisplayName("§aAjouter +1 Min Bordure");
        AddBordure.setItemMeta(AddBordureMeta);
        inv.setItem(15, AddBordure);

        ItemStack RemoveBordure = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.RED.getData());
        ItemMeta RemoveBordureMeta = RemoveBordure.getItemMeta();
        RemoveBordureMeta.setDisplayName("§cRetirer -1 Min Bordure");
        RemoveBordure.setItemMeta(RemoveBordureMeta);
        inv.setItem(33, RemoveBordure);

    }

    public static void openMenuGamemode(Player p){
        Inventory inv = Bukkit.createInventory(null, 45, "§c§lGestion des Modes de Jeu");
        p.openInventory(inv);

        inv.setItem(10, itemConstructor.getItem(Material.GRASS, "§c§lUHC Classique", false, 1));
        inv.setItem(12, itemConstructor.getItem(Material.RABBIT_FOOT, "§c§lDanganronpa UHC", false, 1));
        inv.setItem(14, itemConstructor.getItem(Material.DRAGON_EGG, "§c§lSpeedrun", false, 1));

    }
    public static void openMenuBorder(Player p){
        Inventory inv = Bukkit.createInventory(null, 45, "§c§lGestion de la Bordure");

        p.openInventory(inv);

        ItemStack pvp = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta pvpMeta = pvp.getItemMeta();
        pvpMeta.setDisplayName("§c§lTaille Bordure Avant Activation");
        pvpMeta.setLore(Arrays.asList(" ", "§cTaille Bordure: §e" + Main.BordureAvant + ""));
        pvp.setItemMeta(pvpMeta);
        inv.setItem(20, pvp);

        ItemStack Border = new ItemStack(Material.IRON_BLOCK);
        ItemMeta BorderMeta = pvp.getItemMeta();
        BorderMeta.setDisplayName("§c§lTaille Bordure après activation");
        BorderMeta.setLore(Arrays.asList(" ", "§cTaille Bordure: §e" + Main.BordureApres + ""));
        Border.setItemMeta(BorderMeta);
        inv.setItem(24, Border);

        ItemStack AddPvP = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.LIME.getData());
        ItemMeta AddPvPMeta = AddPvP.getItemMeta();
        AddPvPMeta.setDisplayName("§aAjouter +50 Bloc Avant");
        AddPvP.setItemMeta(AddPvPMeta);
        inv.setItem(11, AddPvP);

        ItemStack RemovePvP = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.RED.getData());
        ItemMeta RemovePvPMeta = RemovePvP.getItemMeta();
        RemovePvPMeta.setDisplayName("§cRetirer -50 Bloc Avant");
        RemovePvP.setItemMeta(RemovePvPMeta);
        inv.setItem(29, RemovePvP);

        ItemStack AddBordure = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.LIME.getData());
        ItemMeta AddBordureMeta = AddBordure.getItemMeta();
        AddBordureMeta.setDisplayName("§aAjouter +50 Bloc Après");
        AddBordure.setItemMeta(AddBordureMeta);
        inv.setItem(15, AddBordure);

        ItemStack RemoveBordure = new ItemStack(Material.STAINED_GLASS, 1, DyeColor.RED.getData());
        ItemMeta RemoveBordureMeta = RemoveBordure.getItemMeta();
        RemoveBordureMeta.setDisplayName("§cRetirer -50 Bloc Après");
        RemoveBordure.setItemMeta(RemoveBordureMeta);
        inv.setItem(33, RemoveBordure);

    }




}
