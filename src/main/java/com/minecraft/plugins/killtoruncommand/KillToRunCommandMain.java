package com.minecraft.plugins.killtoruncommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class KillToRunCommandMain extends JavaPlugin {

    private static KillToRunCommandMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        File folder = new File(String.valueOf(getDataFolder()));
        File playerDataFolder = new File(getDataFolder() + "/playerData");
        File config_file = new File(getDataFolder(), "config.yml");
        if (!folder.exists() || !config_file.exists()) {
            saveDefaultConfig();
        }
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }

        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "杀人者执行命令插件已加载！");

        Bukkit.getPluginManager().registerEvents(new KillListener(), this);

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "杀人者执行命令插件已卸载！");
    }

    public static KillToRunCommandMain getInstance(){
        return plugin;
    }
}
