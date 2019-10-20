package me.tyler.firstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("Die Activated...");
            player.setHealth(0);
            return true;
        } else {
            sender.sendMessage("You need to be a player to execute this command!");
            return false;
        }
    }
}
