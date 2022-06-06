package fr.azrotho.uhccore.utils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class superHeroes {
    public static void SuperHeroes(Player p){
        int id = (int) (Math.random() * 10);
        switch (id){
            case 0:
            case 5:
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000 * 20, 0, true));
                break;
            case 1:
                p.setMaxHealth(40);
                p.setHealth(40);
                break;
            case 2:
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000 * 20, 4, true));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000 * 20, 0, true));
                break;
            case 3:
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000 * 20, 1, true));
                break;
            case 4:
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10000 * 20, 0, true));
                break;
        }
    }
}
