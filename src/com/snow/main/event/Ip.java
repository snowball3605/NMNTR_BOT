package com.snow.main.event;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ip extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String e = "IP: nrts1.ddns.net \nversion: 1.19";
        String message = event.getMessage().getContentRaw();
        if(message.equals("IP")){
            event.getChannel().sendMessage(e).queue();
        }else if(message.equals("ip")){
            event.getChannel().sendMessage(e).queue();
        }else if(message.equals("what is ip")){
            event.getChannel().sendMessage(e).queue();
        }else if(message.equals("What is IP")){
            event.getChannel().sendMessage(e).queue();
        }else if(message.equals("Ip")){
            event.getChannel().sendMessage(e).queue();
        }
    }
}
