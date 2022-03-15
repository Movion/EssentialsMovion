package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.ADVENTURE;

public class CommandAdventure implements CommandExecutor {


    private final MovionEssentials plugin;

    public CommandAdventure(MovionEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.setGameMode(ADVENTURE);
                player.sendMessage(MovionEssentials.prefix + "gamemode set to adventure");
                return true;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.setGameMode(ADVENTURE);
                    player.sendMessage(MovionEssentials.prefix + "adventure set for " + target.getDisplayName());
                    target.sendMessage((MovionEssentials.prefix + "your gamemode was updated to adventure by " + player.getDisplayName()));

                } else {
                    player.sendMessage(MovionEssentials.prefix + "player " + args[0] + "does not exist");
                }
                return true;
            }
        }
        return true;
    }
}

