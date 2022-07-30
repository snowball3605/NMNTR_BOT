package com.snow.main.comm.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import static com.snow.main.util.CommandOption.*;

public class vote {

    static public class Step {
        static public String Question = "";
        static public String Option_1 = "";
        static public String Option_2 = "";
        static public String Option_3 = "";
        static public String Option_4 = "";
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("vote"))  return;
        if (!event.isFromGuild()) {
            event.getInteraction().deferReply(true).setContent("請在伺服器內使用此指令").queue();
            return;
        }
        String question = event.getOption(QUESTION).getAsString();
        String option_1 = event.getOption(OPTION_1).getAsString();
        String option_2 = event.getOption(OPTION_2).getAsString();
        String option_3 = event.getOption(OPTION_3).getAsString();
        String option_4 = event.getOption(OPTION_4).getAsString();
        System.out.println(question);
        System.out.println(option_1);
        System.out.println(option_2);
        System.out.println(option_3);
        System.out.println(option_4);
        }
    }
