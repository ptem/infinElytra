package me.solarshrieking.infinElytra;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Main Created by SolarShrieking on 3/14/2016.
 * Function of Class: Das Main
 */
public class Main extends JavaPlugin {

    public Main plugin = this;
    Logger log = this.getLogger();

    @Override
    public void onLoad() {
        plugin = this;
    }


    @Override
    public void onEnable() {
        getLogger().info("infinElytra is now loading!");
        new PlayerListener(this);

    }

    @Override
    public void onDisable() {
        getLogger().info("infinElytra has been disabled!");
    }



}
