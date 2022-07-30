package com.snow.main.event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;

public class onGuildVoiceMove {

    public void onVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        Guild guild = event.getGuild();
        String meme = event.getMember().getUser().getName();
        String channelMove = event.getChannelJoined().getName();
        EmbedBuilder a = new EmbedBuilder()
                .setColor(new Color(0xFD7300))
                .setTitle(meme + "\n移動到" + channelMove)
                .setTimestamp(Instant.now());
        guild.getTextChannelById("953659969788575765").sendMessageEmbeds(a.build()).queue();
    }
}
