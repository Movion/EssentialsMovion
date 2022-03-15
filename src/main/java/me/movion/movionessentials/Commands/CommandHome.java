package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHome implements CommandExecutor {

    private final MovionEssentials plugin;

    public CommandHome(MovionEssentials plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            Location location = plugin.getConfig().getLocation(String.valueOf(player.getUniqueId()));
            if(location != null){
                player.teleport(location);
                player.sendMessage(MovionEssentials.prefix + "returned to home");
            }else{
                player.sendMessage(MovionEssentials.prefix + "No home set. use /sethome to set a new home");
            }

            //check if location is already set

        }
        return true;
    }
}
