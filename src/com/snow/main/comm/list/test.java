package com.snow.main.comm.list;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.lang.reflect.Member;
import java.util.Objects;

public class test {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("test")) return;
    }
}
