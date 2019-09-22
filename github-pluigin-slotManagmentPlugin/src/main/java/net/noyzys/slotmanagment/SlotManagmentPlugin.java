package net.noyzys.slotmanagment;

import org.bukkit.plugin.java.JavaPlugin;

public final class SlotManagmentPlugin extends JavaPlugin {

    private String prefix = "[SlotManagmentPlugin]: ";
    private SlotManagmentConfiguration configuration;
    private SlotManagmentManager slotManagmentManager;
   @Override
    public void onEnable() {
        this.initialize();
        this.getLogger().info(this.prefix + this.configuration.getPlugin_enable());
    }

    private void initialize() {
        //<-- initialize configuration, manager -->
        this.configuration = new SlotManagmentConfiguration(this);
        this.slotManagmentManager = new SlotManagmentManager(this);

        //<-- register command, listener -->
        new SlotManagmentCommand(this);
        new SlotManagmentListener(this);
        this.getLogger().info(this.prefix + this.configuration.getPlugin_loading());
    }

    @Override
    public void onDisable() {
        this.getLogger().info(this.prefix + this.configuration.getPlugin_disable());
    }

    public SlotManagmentConfiguration getConfiguration() {
        return configuration;
    }

    public SlotManagmentManager getSlotManagmentManager() {
        return slotManagmentManager;
    }
}
