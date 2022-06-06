package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class hasteyBoy implements Listener{
    @EventHandler
    public void Hastey(PrepareItemCraftEvent e) {
        if(Main.getScenarios().get("HasteyBoy")) {
            ItemStack lo1;
            ItemMeta lo1M;
            ItemStack l1;
            ItemMeta l1M;
            ItemStack lj1;
            ItemMeta lj1M;
            ItemStack lI1;
            ItemMeta lI1M;
            ItemStack lN1;
            ItemMeta lN1M;
            ItemStack le1;
            ItemMeta leN1M;
            ItemStack lep1;
            ItemMeta lepN1M;
            ItemStack leB1;
            ItemMeta leBN1M;
            ItemStack lXe1;
            ItemMeta lXeN1M;
            ItemStack leJ1;
            ItemMeta leJN1M;
            ItemStack lHe1;
            ItemMeta leHN1M;
            ItemStack lHej1;
            ItemMeta leHNj1M;
            ItemStack lnHej1;
            ItemMeta nleHNj1M;
            ItemStack t1;
            ItemMeta t1M;
            ItemStack Jt1;
            ItemMeta Jt1M;
            ItemStack hJt1;
            ItemMeta hJt1M;
            ItemStack FlnHej1;
            ItemMeta FnleHNj1M;
            ItemStack Qt1;
            ItemMeta Qt1M;
            ItemStack PJt1;
            ItemMeta PJt1M;
            ItemStack VhJt1;
            ItemMeta VhJt1M;
            Material itemType = Objects.requireNonNull(e.getInventory().getResult()).getType();
            switch (itemType) {
                case WOOD_PICKAXE:
                    lo1 = new ItemStack(Material.STONE_PICKAXE);
                    lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lo1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                case WOOD_AXE:
                    l1 = new ItemStack(Material.STONE_AXE);
                    l1M = l1.getItemMeta();
                    l1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    l1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    l1.setItemMeta(l1M);
                    e.getInventory().setResult(l1);
                    break;
                case WOOD_SPADE:
                    lj1 = new ItemStack(Material.STONE_SPADE);
                    lj1M = lj1.getItemMeta();
                    lj1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lj1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lj1.setItemMeta(lj1M);
                    e.getInventory().setResult(lj1);
                    break;
                case WOOD_HOE:
                    lI1 = new ItemStack(Material.STONE_HOE);
                    lI1M = lI1.getItemMeta();
                    lI1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lI1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lI1.setItemMeta(lI1M);
                    e.getInventory().setResult(lI1);
                    break;
                case STONE_PICKAXE:
                    lN1 = new ItemStack(Material.STONE_PICKAXE);
                    lN1M = lN1.getItemMeta();
                    lN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lN1.setItemMeta(lN1M);
                    e.getInventory().setResult(lN1);
                    break;
                case STONE_AXE:
                    le1 = new ItemStack(Material.STONE_AXE);
                    leN1M = le1.getItemMeta();
                    leN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    leN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    le1.setItemMeta(leN1M);
                    e.getInventory().setResult(le1);
                    break;
                case STONE_SPADE:
                    lep1 = new ItemStack(Material.STONE_SPADE);
                    lepN1M = lep1.getItemMeta();
                    lepN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lepN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lep1.setItemMeta(lepN1M);
                    e.getInventory().setResult(lep1);
                    break;
                case STONE_HOE:
                    leB1 = new ItemStack(Material.STONE_HOE);
                    leBN1M = leB1.getItemMeta();
                    leBN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    leBN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    leB1.setItemMeta(leBN1M);
                    e.getInventory().setResult(leB1);
                    break;
                case IRON_PICKAXE:
                    lXe1 = new ItemStack(Material.IRON_PICKAXE);
                    lXeN1M = lXe1.getItemMeta();
                    lXeN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    lXeN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lXe1.setItemMeta(lXeN1M);
                    e.getInventory().setResult(lXe1);
                    break;
                case IRON_AXE:
                    leJ1 = new ItemStack(Material.IRON_AXE);
                    leJN1M = leJ1.getItemMeta();
                    leJN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    leJN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    leJ1.setItemMeta(leJN1M);
                    e.getInventory().setResult(leJ1);
                    break;
                case IRON_SPADE:
                    lHe1 = new ItemStack(Material.IRON_SPADE);
                    leHN1M = lHe1.getItemMeta();
                    leHN1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    leHN1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lHe1.setItemMeta(leHN1M);
                    e.getInventory().setResult(lHe1);
                    break;
                case IRON_HOE:
                    lHej1 = new ItemStack(Material.IRON_HOE);
                    leHNj1M = lHej1.getItemMeta();
                    leHNj1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    leHNj1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lHej1.setItemMeta(leHNj1M);
                    e.getInventory().setResult(lHej1);
                    break;
                case GOLD_PICKAXE:
                    lnHej1 = new ItemStack(Material.GOLD_PICKAXE);
                    nleHNj1M = lnHej1.getItemMeta();
                    nleHNj1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    nleHNj1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    lnHej1.setItemMeta(nleHNj1M);
                    e.getInventory().setResult(lnHej1);
                    break;
                case GOLD_AXE:
                    t1 = new ItemStack(Material.GOLD_AXE);
                    t1M = t1.getItemMeta();
                    t1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    t1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    t1.setItemMeta(t1M);
                    e.getInventory().setResult(t1);
                    break;
                case GOLD_SPADE:
                    Jt1 = new ItemStack(Material.GOLD_SPADE);
                    Jt1M = Jt1.getItemMeta();
                    Jt1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    Jt1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    Jt1.setItemMeta(Jt1M);
                    e.getInventory().setResult(Jt1);
                    break;
                case GOLD_HOE:
                    hJt1 = new ItemStack(Material.GOLD_HOE);
                    hJt1M = hJt1.getItemMeta();
                    hJt1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    hJt1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    hJt1.setItemMeta(hJt1M);
                    e.getInventory().setResult(hJt1);
                    break;
                case DIAMOND_PICKAXE:
                    FlnHej1 = new ItemStack(Material.DIAMOND_PICKAXE);
                    FnleHNj1M = FlnHej1.getItemMeta();
                    FnleHNj1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    FnleHNj1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    FlnHej1.setItemMeta(FnleHNj1M);
                    e.getInventory().setResult(FlnHej1);
                    break;
                case DIAMOND_AXE:
                    Qt1 = new ItemStack(Material.DIAMOND_AXE);
                    Qt1M = Qt1.getItemMeta();
                    Qt1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    Qt1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    Qt1.setItemMeta(Qt1M);
                    e.getInventory().setResult(Qt1);
                    break;
                case DIAMOND_SPADE:
                    PJt1 = new ItemStack(Material.DIAMOND_SPADE);
                    PJt1M = PJt1.getItemMeta();
                    PJt1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    PJt1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    PJt1.setItemMeta(PJt1M);
                    e.getInventory().setResult(PJt1);
                    break;
                case DIAMOND_HOE:
                    VhJt1 = new ItemStack(Material.DIAMOND_HOE);
                    VhJt1M = VhJt1.getItemMeta();
                    VhJt1M.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    VhJt1M.addEnchant(Enchantment.DURABILITY, 3, true);
                    VhJt1.setItemMeta(VhJt1M);
                    e.getInventory().setResult(VhJt1);
                    break;
            }
        }
    }
}
