package me.movion.movionessentials.Commands;

import me.movion.movionessentials.MovionEssentials;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSethome implements CommandExecutor {
    private final MovionEssentials plugin;

    public CommandSethome(MovionEssentials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if(sender instanceof Player player){

            //get Location
            Location location = player.getLocation();
            plugin.getConfig().set(String.valueOf(player.getUniqueId()),location);
            plugin.saveConfig();
            player.sendMessage(MovionEssentials.prefix + "home set to current location");

        }else{
            System.out.println("This command works only for players.");
        }
        return true;
    }
}
