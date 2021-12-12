package net.hexxcraft.log4j_prevent.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import net.hexxcraft.log4j_prevent.Log4j_Prevent;

public class ChatListener implements Listener {
    private final Log4j_Prevent plugin;

    public ChatListener(Log4j_Prevent plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onSendMessage(ChatEvent event){
        if(event.getMessage().toLowerCase().contains("${jndi")){
            event.setCancelled(true);

            if(event.getSender() instanceof ProxiedPlayer){
                for (ProxiedPlayer player : plugin.getProxy().getPlayers()) {
                    if(player.isConnected() && player.hasPermission("log4j_prevent.notification")){
                        player.sendMessage("§8[§bHexxGuard§8] §6" + ((ProxiedPlayer) event.getSender()).getDisplayName() + " §ctried to use the log4j exploit!");
                    }
                }

                plugin.getLogger().info("§8[§bHexxGuard§8] §6" + ((ProxiedPlayer) event.getSender()).getDisplayName() + " §ctried to use the log4j exploit!");
            }

        }
    }
}
