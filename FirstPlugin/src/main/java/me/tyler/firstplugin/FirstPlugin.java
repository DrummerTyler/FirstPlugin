package me.tyler.firstplugin;

import me.tyler.firstplugin.onJoin.onJoin;
import me.tyler.firstplugin.onJoin.onLeave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Your First Plugin Has been Enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onLeave(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Your First Plugin Has Been Disabled");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.sendMessage("You left the bed");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("die")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("Die Activated...");
                player.setHealth(0);
            }else{
                System.out.println("You need to be a player to execute this command!");
            }
        }

        if(command.getName().equals("hp")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("HeathPls Activated...");
                player.setHealth(20);
            }else{
                System.out.println("You need to be a player to execute this command!");
            }
        }

        return false;
    }

}