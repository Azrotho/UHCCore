package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class randomizer implements Listener {

    @EventHandler
    public void Randomize(BlockBreakEvent e) {
        e.setCancelled(true);
        if (Main.getScenarios().get("Random")) {
            if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(
                        Main.getRandom().get(e.getBlock().getType())));
            }
            e.getBlock().setType(Material.AIR);
        }
    }
    public static void randomList() {

        ArrayList<Material> randomed = new ArrayList<Material>();
        for (Material mat : Material.values()) {
            if(!mat.isBlock()){
                randomed.add(mat);
            }
        }
        for (Material mat : Material.values()) {
            if(!mat.isBlock()){
                randomed.add(mat);
            }
        }
        for (Material mat : Material.values()) {
            if(!mat.isBlock()){
                randomed.add(mat);
            }
        }
        for (Material mat : Material.values()) {
            if(!mat.isBlock()){
                randomed.add(mat);
            }
        }

        Collections.shuffle(randomed);


        for (Material mat : Material.values()) {
            if(mat.isBlock()) {
                if(randomed.get(0) != null) {
                    Main.getRandom().put(mat, randomed.get(0));
                    randomed.remove(0);
                }
            }else{
                  Main.getRandom().put(mat, Material.AIR);
                }
        }
    }
}
