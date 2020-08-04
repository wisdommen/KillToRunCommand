package com.minecraft.plugins.killtoruncommand;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

public class KillListener implements Listener {

    @EventHandler
    public void onPlayerKillPlayer(PlayerDeathEvent event) {
        if(event.getEntity().getKiller()!=null) {
            Player killer = event.getEntity().getKiller();
            List<String> consoleCommands = KillToRunCommandMain.getInstance().getConfig().getStringList("console-commands");
            for (String each : consoleCommands) {
                while (each.contains("{PLAYER}")){
                    each = each.replace("{PLAYER}", killer.getName());
                }
                Bukkit.dispatchCommand(KillToRunCommandMain.getInstance().getServer().getConsoleSender(), each);
            }
            List<String> playerCommands = KillToRunCommandMain.getInstance().getConfig().getStringList("player-commands");
            for (String each : playerCommands) {
                Bukkit.dispatchCommand(killer, each);
            }
        }
    }
}
