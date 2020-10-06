package net.teamfruit.findingafk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class FindingAFK extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Server server = getServer();

        server.broadcastMessage(ChatColor.GREEN + "========= ▼リスポせず放置一覧▼ =========");
        server.getOnlinePlayers().stream().filter(e -> e.isDead()).forEach(e ->
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + e.getName()));
        server.broadcastMessage(ChatColor.GREEN + "========= ▲リスポせず放置一覧▲ =========");

        return true;
    }
}
