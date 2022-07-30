package com.snow.main.comm.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Invite extends ListenerAdapter {
    public void onCommand(MessageReceivedEvent event){
        if (event.getMessage().getContentRaw().equals("invite")) {
            event.getChannel().sendMessage(event.getTextChannel().createInvite().complete().getUrl()).queue();
        }
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("invite")) return; // 過略掉指令名字不是 invite 的指令
        if (!event.isFromGuild()) return; // 如果使用者不是在 guild 執行指令, 即跳出

        String inviteURL = event.getTextChannel().createInvite().complete().getUrl();

        event.getInteraction().deferReply(true).setContent(inviteURL).queue();
    }
}
