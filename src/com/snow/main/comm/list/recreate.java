package com.snow.main.comm.list;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import static com.snow.main.Main.guild;

public class recreate {

    public static class Channel {
        public static String Name;
        public static String ID;
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("recreate")) return;
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.getInteraction().deferReply(true).setContent("你沒有權限").queue();
        }
        Channel.Name = event.getChannel().getName();
        event.getChannel().delete().queue();
        guild.createTextChannel(Channel.Name).queue(textChannel -> {
            textChannel.sendMessage("請重新創建權限").queue();
        });
    }
}
