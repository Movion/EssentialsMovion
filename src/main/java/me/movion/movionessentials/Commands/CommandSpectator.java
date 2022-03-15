package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.SPECTATOR;

public class CommandSpectator implements CommandExecutor {


    private final MovionEssentials plugin;

    public CommandSpectator(MovionEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.setGameMode(SPECTATOR);
                player.sendMessage(MovionEssentials.prefix + "gamemode set to spectator");
                return true;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.setGameMode(SPECTATOR);
                    player.sendMessage(MovionEssentials.prefix + "spectator set for " + target.getDisplayName());
                    target.sendMessage((MovionEssentials.prefix + "your gamemode was updated to spectator by " + player.getDisplayName()));

                } else {
                    player.sendMessage(MovionEssentials.prefix + "player " + args[0] + "does not exist");
                }
                return true;
            }
        }
        return true;
    }
}

