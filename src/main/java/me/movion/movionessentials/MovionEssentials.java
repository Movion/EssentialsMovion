package me.movion.movionessentials;

import me.movion.movionessentials.Commands.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MovionEssentials extends JavaPlugin {

    public final static String prefix = ChatColor.RED + "" + ChatColor.BOLD + "MovionEssentials » " + ChatColor.GRAY;

    @Override
    public void onEnable() {
        // Plugin startup logic

        //set default Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Commands
        getCommand("gmc").setExecutor(new CommandCreative(this));
        getCommand("gms").setExecutor(new CommandSurvival(this));
        getCommand("gma").setExecutor(new CommandAdventure(this));
        getCommand("gmsp").setExecutor(new CommandSpectator(this));
        getCommand("sethome").setExecutor(new CommandSethome(this));
        getCommand("home").setExecutor(new CommandHome(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
