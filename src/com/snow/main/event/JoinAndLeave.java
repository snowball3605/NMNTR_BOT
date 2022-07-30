package com.snow.main.event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;

import java.awt.*;
import java.time.Instant;

public class JoinAndLeave {

    public void onLeave(GuildMemberRemoveEvent event) {
        int memberCount = event.getGuild().getMemberCount();
        EmbedBuilder a = new EmbedBuilder()
                .setColor(new Color(67, 239, 152))
                .setDescription(event.getUser().getAsMention() + "leave了")
                .setFooter(memberCount + "人數")
                .setTimestamp(Instant.now());
        int Count = event.getGuild().getMemberCount();
        System.out.println(event.getUser().getAsMention());
        event.getGuild().getVoiceChannelById("946364391492825098").getManager().setName("人數|Member:"+ Count).queue();
        event.getGuild().getTextChannelById("965088131168743454").sendMessageEmbeds(a.build()).queue();
    }

    public void onJoin(GuildMemberJoinEvent event) {
        User member = event.getUser();
        EmbedBuilder eb = new EmbedBuilder()
                .setColor(new Color(67, 239, 152))
                .setDescription(event.getMember().getUser().getAsMention() + "加入了")
                .setFooter(event.getGuild().getMemberCount() + "人數")
                .setTimestamp(Instant.now());
        System.out.println(event.getMember().getUser().getAsMention());
        int Count = event.getGuild().getMemberCount();
        event.getGuild().getVoiceChannelById("946364391492825098").getManager().setName("人數|Member:"+ Count).queue();

        Role role = event.getGuild().getRoleById(String.valueOf("825607310084014081"));
        assert role != null;
        event.getGuild().addRoleToMember(event.getMember(), role).queue();
        event.getGuild().getTextChannelById("965088131168743454").sendMessageEmbeds(eb.build()).queue();
    }
}
