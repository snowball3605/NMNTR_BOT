package com.snow.main.comm.list;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class help extends ListenerAdapter {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("help")) return;
            if (!event.getGuild().getSelfMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply(true).setContent("你並沒有權限使用").queue();
                return;}
                event.getChannel().sendMessage("請選擇你的機械人").setActionRow(sendServer()).queue();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static SelectMenu sendServer() {
        return SelectMenu.create("info")
                .setPlaceholder("bot ")
                .addOption("testsnow", "testsnow", "testsnow是JAVA製作的")
                .addOption("testbot", "testbot", "testbot是Python製作的")
                .setRequiredRange(1, 1)
                .build();
    }


}
