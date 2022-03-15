package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.CREATIVE;

public class CommandCreative implements CommandExecutor {


    private final MovionEssentials plugin;

    public CommandCreative(MovionEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.setGameMode(CREATIVE);
                player.sendMessage(MovionEssentials.prefix + "gamemode set to creative");
                return true;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.setGameMode(CREATIVE);
                    player.sendMessage(MovionEssentials.prefix + "creative set for " + target.getDisplayName());
                    target.sendMessage((MovionEssentials.prefix + "your gamemode was updated to creative by " + player.getDisplayName()));

                } else {
                    player.sendMessage(MovionEssentials.prefix + "player " + args[0] + "does not exist");
                }
                return true;
            }
        }
        return true;
    }
}

