package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.SURVIVAL;

public class CommandSurvival implements CommandExecutor {


    private final MovionEssentials plugin;

    public CommandSurvival(MovionEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.setGameMode(SURVIVAL);
                player.sendMessage(MovionEssentials.prefix + "gamemode set to survival");
                return true;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.setGameMode(SURVIVAL);
                    player.sendMessage(MovionEssentials.prefix + "survival set for " + target.getDisplayName());
                    target.sendMessage((MovionEssentials.prefix + "your gamemode was updated to survival by " + player.getDisplayName()));


                } else {
                    player.sendMessage(MovionEssentials.prefix + "player " + args[0] + "does not exist");
                }
                return true;
            }
        }
        return true;
    }
}

