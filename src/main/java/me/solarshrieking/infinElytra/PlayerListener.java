package me.solarshrieking.infinElytra;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.util.Vector;

/**
 * PlayerListener Created by SolarShrieking on 3/14/2016.
 * Function of Class: ${doingThings}
 */
public class PlayerListener implements Listener {

    private final Main plugin;
    public int taskID;

    public PlayerListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void elytraEvent(EntityToggleGlideEvent glideEvent) {
        Entity entity = glideEvent.getEntity();
        if (entity instanceof Player) {

            final Player player = (Player) entity;

            if (!player.isGliding()) {
                Bukkit.getScheduler().cancelTask(taskID);
            } else if (player.isGliding()) {

                double x = player.getVelocity().getX();
                final double y = player.getVelocity().getY();
                double z = player.getVelocity().getZ();


                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        double nY = player.getVelocity().getY();

                        if (y > 0) {

                            if (nY > y) {
                                double newY = (nY - y) + y;
                                //player.sendMessage(ChatColor.GREEN + "new Velocity is INCREASING! Current Velocity" + player.getVelocity().getY());
                                Vector newVelo = new Vector(x, newY, z);
                                player.setVelocity(newVelo);
                                //player.sendMessage("Setting Y Velocity to: " + newY);


                            } else if (nY < y) {
                                //player.sendMessage(ChatColor.RED + "Velocity is DECREASING! Current Velocity" + player.getVelocity().getY());

                            } else if (nY == y) {
                                //player.sendMessage(ChatColor.GOLD + "VELOCITY IS THE SAME! Current Velocity" + player.getVelocity().getY());
                            }
                        }
                    }
                }, 20L);

            } else if (!player.isGliding()) {
                //player.sendMessage("You're not gliding!");
                Bukkit.getScheduler().cancelTask(taskID);
            }

        }

    }
}
