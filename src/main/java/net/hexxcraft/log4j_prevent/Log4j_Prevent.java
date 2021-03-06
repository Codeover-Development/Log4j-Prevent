package net.hexxcraft.log4j_prevent;

import net.hexxcraft.log4j_prevent.listeners.ChatListener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import java.util.logging.Logger;

public final class Log4j_Prevent extends Plugin {
    private final Logger logger = getProxy().getLogger();

    @Override
    public void onEnable() {
        logger.info("---------[Log4j-Prevent]---------");

        logger.info("loading listeners...");

        PluginManager pluginManager = getProxy().getPluginManager();
        pluginManager.registerListener(this, new ChatListener(this));

        logger.info("---------[Log4j-Prevent]---------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
