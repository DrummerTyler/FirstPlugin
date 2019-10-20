package me.tyler.firstplugin;

import me.tyler.firstplugin.commands.DieCommand;
import me.tyler.firstplugin.commands.HpCommand;
import me.tyler.firstplugin.events.OnJoin;
import me.tyler.firstplugin.events.OnLeave;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Your First Plugin Has been Enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnLeave(), this);

        // Register commands
        this.getCommand("die").setExecutor(new DieCommand());
        this.getCommand("hp").setExecutor(new HpCommand());
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

    // Removed command handling here and moved to seperate classes:
    // me.tyler.firstplugin.commands.*

    /*
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("die")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("Die Activated...");
                player.setHealth(0);
            } else {
                System.out.println("You need to be a player to execute this command!");
            }
        }

        if(command.getName().equals("hp")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("HeathPls Activated...");
                player.setHealth(20);
            } else {
                System.out.println("You need to be a player to execute this command!");
            }
        }

        return false;
    }
    */
}