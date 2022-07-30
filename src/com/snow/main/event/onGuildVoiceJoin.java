package com.snow.main.event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;

public class onGuildVoiceJoin {

    public void onVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        if (!event.getGuild().getId().equals("825162735603810316")) return;

        Guild guild = event.getGuild();
        if (guild.getVoiceChannelById(event.getChannelJoined().getId()) == null)
            return;
        String meme = event.getMember().getUser().getName();
            String channeljoin = event.getChannelJoined().getName();
            EmbedBuilder b = new EmbedBuilder()
                    .setColor(new Color(0x008000))
                    .setTitle(meme + "\n進入\n ➡" + channeljoin)
                    .setTimestamp(Instant.now());
            guild.getTextChannelById("953659969788575765").sendMessageEmbeds(b.build()).queue();
        }
    }


