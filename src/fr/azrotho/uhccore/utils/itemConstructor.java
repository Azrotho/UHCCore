package fr.azrotho.uhccore.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemConstructor {
    public static ItemStack getItem(Material material, String customName, Boolean enchanted, Integer amount){
        ItemStack it = new ItemStack(material, amount);
        ItemMeta itM = it.getItemMeta();
        if(customName != null) itM.setDisplayName(customName);
        if(enchanted) {
            itM.addEnchant(Enchantment.LUCK, 0, true);
        }
        it.setItemMeta(itM);
        return it;
    }
}
