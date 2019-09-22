package net.noyzys.slotmanagment;

import net.noyzys.slotmanagment.extension.message.StringMessageExtension;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class SlotManagmentCommand implements CommandExecutor {

    private final SlotManagmentPlugin plugin;

    public SlotManagmentCommand(SlotManagmentPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("slot").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(this.plugin.getConfiguration().getCommand_permission())) {
            StringMessageExtension
                    .create(this.plugin.getConfiguration().getCommand_permission_message())
                    .sendMessage(sender);
            return true;
        }

        if (args.length < 1) return StringMessageExtension
                .create(this.plugin.getConfiguration().getCommand_usage())
                .sendMessage(sender);

        if (!this.isInteger(args[0])) return StringMessageExtension
                .create(this.plugin.getConfiguration().getCommand_it_is_notnumber())
                .sendMessage(sender);

        int slot = Integer.parseInt(args[0]);
        this.plugin.getSlotManagmentManager().setSlot_limit(slot);

        StringMessageExtension
                .create(this.plugin.getConfiguration().getCommand_present_status_slot()
                .replace("{SLOT}", slot + ""))
                .sendMessage(sender);
        return StringMessageExtension
                .create(this.plugin.getConfiguration().getCommand_setslot()
                        .replace("{ONLINE}", this.plugin.getServer().getOnlinePlayers().size() + "")
                        .replace("{SLOT}", slot + ""))
                .sendMessage(sender);
    }

    private boolean isInteger(@NotNull String string) {
        return Pattern
                .matches("-?[0-9]+", string.subSequence(0, string.length())
                );
    }
}
