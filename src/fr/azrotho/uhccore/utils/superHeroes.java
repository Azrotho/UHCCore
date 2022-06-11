package fr.azrotho.uhccore.utils;

import fr.azrotho.uhccore.Main;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class superHeroes {
    public static void SuperHeroes(Player p){
        int id = (int) (Math.random() * 10);
        switch (id){
            case 0:
            case 5:
            case 10:
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000 * 20, 0, true));
                break;
            case 1:
            case 6:
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 10000 * 20, 4, true));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 255, true));
                break;
            case 2:
            case 7:
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000 * 20, 4, true));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000 * 20, 0, true));
                Main.getNoFall().put(p.getUniqueId(), true);
                break;
            case 3:
            case 8:
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000 * 20, 1, true));
                break;
            case 4:
            case 9:
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10000 * 20, 0, true));
                break;
        }
    }
}
