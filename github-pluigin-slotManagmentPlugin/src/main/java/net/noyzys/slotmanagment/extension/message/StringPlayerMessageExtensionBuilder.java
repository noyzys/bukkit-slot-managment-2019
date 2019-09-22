package net.noyzys.slotmanagment.extension.message;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class StringPlayerMessageExtensionBuilder {

    @NotNull
    @Contract(pure = true)
    StringPlayerMessageExtensionBuilder(String message) {
        this.message = message;
    }

    private String message;

    public boolean sendMessage(@NotNull CommandSender commandSender) {
        commandSender.sendMessage(this.message);
        return true;
    }
}
