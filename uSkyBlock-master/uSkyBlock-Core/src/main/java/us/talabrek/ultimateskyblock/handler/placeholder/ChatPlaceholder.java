package us.talabrek.ultimateskyblock.handler.placeholder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import us.talabrek.ultimateskyblock.uSkyBlock;

/**
 * Our native chat-placeholder handler.
 */
public class ChatPlaceholder extends TextPlaceholder implements Listener {
    @Override
    public boolean registerPlaceholder(uSkyBlock plugin, PlaceholderReplacer replacer) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        return super.registerPlaceholder(plugin, replacer);
    }

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        e.setFormat(PlaceholderHandler.replacePlaceholders(player, e.getFormat()));
        e.setMessage(PlaceholderHandler.replacePlaceholders(player, e.getMessage()));
    }
}
