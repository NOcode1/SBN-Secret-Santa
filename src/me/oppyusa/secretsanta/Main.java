package me.oppyusa.secretsanta;

import me.oppyusa.secretsanta.commands.MainCommand;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    FileConfiguration config = this.getConfig();
	
	List<String> ConfigList = config.getStringList("node.path");




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
        if (label.equalsIgnoreCase("nice")) {
	        player.sendMessage("Added you to the nice list.");
	        List<String> good = config.getStringList("good");
            good.add(player.getName());
            config.set("good", good);
	        saveConfig();
        }
        if (label.equalsIgnoreCase("naughty")) {
            player.sendMessage("Added you to the naughty list.");
            List<String> bad = config.getStringList("bad");
            bad.add(player.getName());
            config.set("bad", bad);
            saveConfig();
        }
        if (label.equalsIgnoreCase("naughtylist")) {
        	for(String msg : getConfig().getStringList("bad")){
        		player.sendMessage(msg);
        	}
        }
        if (label.equalsIgnoreCase("nicelist")) {
        	for(String msg : getConfig().getStringList("good")){
        		player.sendMessage(msg);
        	}
        }
        	
        return true;
    }
}
