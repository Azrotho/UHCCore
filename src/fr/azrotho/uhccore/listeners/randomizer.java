package fr.azrotho.uhccore.listeners;

import fr.azrotho.uhccore.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class randomizer implements Listener {

    @EventHandler
    public void Randomize(BlockBreakEvent event){
        if(Main.getScenarios().get("Random")){
            // ?
        }
    }

    public void randomList(){
        for(Material mat : Material.values()){
            if(mat.isBlock()){
                for(Material rand : Material.values()){

                }
            }
        }
    }
}
