package com.snow.main.comm.list;

import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class help2 extends ListenerAdapter{

    public void SelectMenu(SelectMenuInteractionEvent event) {

        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date = event.getGuild().getTimeCreated();
        String form = time.format(date);

        if (event.getComponent().getId().equals("info")) {

            for (int i = 0; i < event.getValues().size(); i++) {

                switch (event.getValues().get(i)) {

                    case "testsnow":
                        event.getInteraction().deferReply().setContent("""
                                ----------testsnow機械人使用教學----------
                                1./help 可以再次查看機械人使用教學
                                2./Ban 封鎖用戶(只限管理員所用)
                                3./clear 可以清理兩個星期內指定數量的信息
                                4./Invite 可以生成邀請連結
                                5./Kick 可以踢除用戶(只限管理員所用)
                                6./unban 可以解除封鎖指定用戶(只限管理員所用)
                                7./countdown 可以計時
                                """).queue();
                        break;

                    case "testbot":
                        event.getInteraction().deferReply().setContent("""
                                ----------testbot機械人使用教學----------
                                    機械人沒開用不了
                                """) .queue();
                        break;
                }
            }
        }
    }
}
