package fr.azrotho.uhccore.utils;

import fr.azrotho.uhccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class checkAlive {
    public static void CheckAliveUHC(){
        int count = 0;

        String pseudo = "null";

        for (Map.Entry<UUID, String> entry : Main.getStatus().entrySet()){
            String Status = entry.getValue();
            if(Objects.equals(Status, "Vivant")){
                count++;
                pseudo = Bukkit.getServer().getPlayer(entry.getKey()).getDisplayName();
            }
        }
        if(count == 1){
            Bukkit.broadcastMessage("§c§l" + pseudo + " §fa remporté la partie!");
        }
    }
}
