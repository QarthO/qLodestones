package gg.quartzdev.qlodestones.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sender {

    public static void message(CommandSender sender, String message){
        if(sender instanceof Player)
            sender.sendMessage(parse(message, false));
        else
            sender.sendMessage(parse(message, true));
    }

    public static void message(CommandSender sender, Messages message){
        message(sender, message.get());
    }

    public static void message(Player player, Messages message){
        message(player, message.get());
    }

    public static void message(Player player, String message){
        player.sendMessage(parse(message, false));

    }

    public static void actionBar(Player player, String message){
        player.sendActionBar(parse(message, false));
    }

    private static Component parse(String message, boolean isConsole){
        MiniMessage mm = MiniMessage.miniMessage();
        Messages msg = isConsole ? Messages.CONSOLE_PREFIX : Messages.CHAT_PREFIX;
        return mm.deserialize(message, Placeholder.parsed("prefix", msg.get()));
    }

    @SuppressWarnings("UnstableApiUsage")
    public static String location(Location location){
        return location.blockX() + ", " + location.blockY() + ", " + location.blockZ();
    }

}
