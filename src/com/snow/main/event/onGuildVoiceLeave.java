package com.snow.main.event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;

public class onGuildVoiceLeave {

    public void onVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        if (!event.getGuild().getId().equals("825162735603810316")) return;

        Guild guild = event.getGuild();
        if (guild.getVoiceChannelById(event.getChannelLeft().getId()) == null)
            return;
        String meme = event.getMember().getUser().getName();
            String channelLeave = event.getChannelLeft().getName();
            EmbedBuilder b = new EmbedBuilder()
                    .setColor(new Color(0xFF0000))
                    .setTitle(meme + "\n離開\n⬅" + channelLeave)
                    .setTimestamp(Instant.now());
            guild.getTextChannelById("953659969788575765").sendMessageEmbeds(b.build()).queue();
        }
    }
