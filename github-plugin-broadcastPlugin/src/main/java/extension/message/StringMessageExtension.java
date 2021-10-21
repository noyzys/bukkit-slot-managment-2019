package extension.message;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class StringMessageExtension {

    @NotNull
    @Contract(pure = true)
    private StringMessageExtension() {
    }

    @NotNull
    public static String colored(@NotNull String message) {
        return ChatColor
                .translateAlternateColorCodes('&', message
                        .replace(">>", "»")
                        .replace("<<", "«")
                );
    }

    public static StringPlayerMessageExtensionBuilder create(@NotNull String message) {
        return new StringPlayerMessageExtensionBuilder(colored(message)
        );
    }
}
