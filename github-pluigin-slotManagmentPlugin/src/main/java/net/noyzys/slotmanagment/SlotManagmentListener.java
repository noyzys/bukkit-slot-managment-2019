package net.noyzys.slotmanagment;

import net.noyzys.slotmanagment.extension.message.StringMessageExtension;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class SlotManagmentListener implements Listener {

    private final SlotManagmentPlugin plugin;

    public SlotManagmentListener(SlotManagmentPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        if (this.plugin.getServer().getOnlinePlayers().size() >= this.plugin.getSlotManagmentManager().getSlot_limit())
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, StringMessageExtension
                    .colored(this.plugin.getConfiguration().getListener_serverisfull()
                            .replace("[N]", "\n"))
            );
    }
}
