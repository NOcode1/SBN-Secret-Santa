package me.oppyusa.secretsanta;

import me.oppyusa.secretsanta.commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    FileConfiguration config = this.getConfig();

    public void onEnable() {

        getLogger().info("Secret Santa Plugin has now loaded");

        this.getCommand("secretsanta").setExecutor(new MainCommand());

        this.saveDefaultConfig();

    }
    public void onDisable() {
        getLogger().info("Secret Santa Plugin has now been disabled");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("good")) {
            if (args.length == 0) {
                player.sendMessage("You must include the player to add to the good list.");
            }
            else {
                Player target = Bukkit.getPlayerExact(args[0]);
                try {
	                player.sendMessage("Added your target to the good list.");
	                config.addDefault("good", target.getName());
	                config.options().copyDefaults(true);
	                saveConfig();
                }
                finally {
                	player.sendMessage("Target is offline.");
                }
            }
        }
        if (label.equalsIgnoreCase("bad")) {
            if (args.length == 0) {
                player.sendMessage("You must include the player to add to the good list.");
            }
            else {
                Player target = Bukkit.getPlayerExact(args[0]);
                try {
	                player.sendMessage("Added your target to the good list.");
	                config.addDefault("bad", target.getName());
	                config.options().copyDefaults(true);
	                saveConfig();
                }
                finally {
                	player.sendMessage("Target is offline.");
                }
            }
        }
        return false;
    }
}
