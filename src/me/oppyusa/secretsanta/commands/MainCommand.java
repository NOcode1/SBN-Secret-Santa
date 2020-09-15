package me.oppyusa.secretsanta.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Defining the player variable
        Player p = (Player) sender;

        // Help structure
        p.sendMessage(ChatColor.GREEN + "---------------");
        p.sendMessage(ChatColor.AQUA + "Skyblock Network Secret Santa");
        p.sendMessage(ChatColor.AQUA + "Programmed by Oppyusa and idea by Wsmnb_02");
        p.sendMessage(ChatColor.GREEN + "---------------");
        p.sendMessage(ChatColor.AQUA + "/good <player> | Mark a player as \"good\"");
        p.sendMessage(ChatColor.AQUA + "/bad <player> | Mark a player as \"bad\"");
        p.sendMessage(ChatColor.AQUA + "/nice | Lists the \"good\" list.");
        p.sendMessage(ChatColor.AQUA + "/naughty <player> | Lists the \"bad\" list.");
        p.sendMessage(ChatColor.GREEN + "---------------");


        return false;
    }
}
