package net.noyzys.slotmanagment;

import java.util.List;

public final class SlotManagmentConfiguration {

    private final SlotManagmentPlugin plugin;

    //<-- Configuration plugin loading -->
    private String plugin_enable;
    private String plugin_loading;
    private String plugin_disable;

    //<-- Configuration command -->
    private String command_permission;
    private String command_permission_message;
    private String command_usage;
    private String command_it_is_notnumber;
    private String command_present_status_slot;
    private String command_setslot;

    //<-- Configuration other -->
    private String listener_serverisfull;

    public SlotManagmentConfiguration(SlotManagmentPlugin plugin) {
        this.plugin = plugin;
        this.loadConfiguration();
    }
    private void loadConfiguration() {
        this.plugin.saveDefaultConfig();

        this.plugin_enable = this.plugin
                .getConfig()
                .getString("plugin_options.enable");
        this.plugin_loading = this.plugin
                .getConfig()
                .getString("plugin_options.loading");
        this.plugin_disable = this.plugin
                .getConfig()
                .getString("plugin_options.disable");

        this.command_permission = this.plugin
                .getConfig()
                .getString("command_options.permission");
        this.command_permission_message = this.plugin
                .getConfig()
                .getString("command_options.message");
        this.command_usage = this.plugin
                .getConfig()
                .getString("command_options.usage");
        this.command_it_is_notnumber = this.plugin
                .getConfig()
                .getString("command_options.it_is_notnumber");
        this.command_present_status_slot = this.plugin
                .getConfig()
                .getString("command_options.present_status_slot");
        this.command_setslot = this.plugin
                .getConfig()
                .getString("command_options.setslot");

        this.listener_serverisfull = this.plugin
                .getConfig()
                .getString("listener_options.serverisfull");
    }

    public String getPlugin_enable() {
        return plugin_enable;
    }

    public String getPlugin_loading() {
        return plugin_loading;
    }

    public String getPlugin_disable() {
        return plugin_disable;
    }

    public String getCommand_permission() {
        return command_permission;
    }

    public String getCommand_permission_message() {
        return command_permission_message;
    }

    public String getCommand_usage() {
        return command_usage;
    }

    public String getCommand_it_is_notnumber() {
        return command_it_is_notnumber;
    }

    public String getCommand_present_status_slot() {
        return command_present_status_slot;
    }

    public String getCommand_setslot() {
        return command_setslot;
    }

    public String getListener_serverisfull() {
        return listener_serverisfull;
    }
}
