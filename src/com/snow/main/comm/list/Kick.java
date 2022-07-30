package com.snow.main.comm.list;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Kick {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("kick")) return;
        if (!event.isFromGuild()) {
            event.getInteraction().deferReply(true).setContent("請在伺服器內使用此指令").queue();
            return;
        }
        if (!event.getGuild().getSelfMember().hasPermission(Permission.KICK_MEMBERS)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }
        Member kickedMember = event.getOption("member").getAsMember();
        assert kickedMember != null;
        if (!event.getGuild().getSelfMember().canInteract(kickedMember)) {
            event.getInteraction().deferReply(true).setContent("此成員的地位比機器人高").queue();
            return;
        }
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }

        String player = kickedMember.getUser().getAsMention();
        kickedMember.kick().queue();
        event.getInteraction().deferReply(true).setContent(player +"Kicked Successfully").queue();
    }
}
