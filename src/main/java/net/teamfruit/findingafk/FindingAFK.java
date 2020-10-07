package net.teamfruit.findingafk;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

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

        Consumer<String> chat = "finddeath".equals(command.getName()) ? server::broadcastMessage : sender::sendMessage;
        chat.accept(ChatColor.GREEN + "========= ▼リスポせず放置してるバカ一覧▼ =========");
        server.getOnlinePlayers().stream().filter(e -> e.isDead()).forEach(e ->
                chat.accept(ChatColor.DARK_GREEN + e.getName()));
        chat.accept(ChatColor.GREEN + "========= ▲リスポせず放置してるバカ一覧▲ =========");

        return true;
    }
}
