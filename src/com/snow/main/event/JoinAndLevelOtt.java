package com.snow.main.event;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.snow.main.event.JoinAndLeaveMain.*;

public class JoinAndLevelOtt  extends ListenerAdapter{


    public void onGuildMessageReceived(MessageReceivedEvent event) {
        event.getMessage().addReaction("✔").queue();
        event.getMessage().addReaction("❌").queue();
    }
    public void GuildReactionAdd(MessageReactionAddEvent event) {

    }
}
