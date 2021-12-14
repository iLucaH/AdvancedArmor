package me.ilucah.advancedarmor;

import me.ilucah.advancedarmor.armor.listeners.ExperienceHandling;
import me.ilucah.advancedarmor.utilities.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ilucah.advancedarmor.commands.ArmorCommand;
import me.ilucah.advancedarmor.handler.Handler;

public class AdvancedArmor extends JavaPlugin {

    private Handler handler;

    @Override
    public void onEnable() {
        this.handler = new Handler(this);

        registerEvents();
        registerCommands();
        registerPlaceholderAPI();

        loadConfig();
        handler.initialiseColors();
        handler.initialiseArmor();
    }

    @Override
    public void onDisable() {

    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ExperienceHandling(handler, this), this);
    }

    private void registerCommands() {
        getCommand("armor").setExecutor(new ArmorCommand(this));
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void registerPlaceholderAPI() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Placeholders(handler, this).register();
        }
    }

    //

    public Handler getHandler() {
        return this.handler;
    }

}
