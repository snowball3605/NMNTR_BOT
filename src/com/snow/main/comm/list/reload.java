package com.snow.main.comm.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class reload {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("reload")) return;
            if (!event.getGuild().getSelfMember().hasPermission((GuildChannel) event.getChannel(), Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply().setContent("你並沒有權限使用此指令").queue(); return;
            }
            if (!event.isFromGuild()) {
                event.getInteraction().deferReply().setContent("請在群組內使用").queue();
                return;
            }
            if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
                return;
            }
            DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            long dateMill = new Date().getTime();
            TextChannel channel = event.getGuild().getTextChannelById("978578508114718730");
            EmbedBuilder a = new EmbedBuilder()
                    .setTitle("主機時區時間")
                    .setFooter("*此時間不等於伺服器內時間")
                    .setDescription(dtf.format(new Date(dateMill)));
            event.getInteraction().deferReply().addEmbeds(a.build()).queue();

            ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();

            if (!threadPool.isShutdown())
                threadPool.shutdown();
            threadPool = Executors.newScheduledThreadPool(1);

            final long[] aff = {2120};

            EmbedBuilder b = new EmbedBuilder()
                    .setTitle("主機時區時間")
                    .setFooter("*此時間不等於伺服器內時間")
                    .setDescription(dtf.format(new Date(dateMill)));

            threadPool.scheduleWithFixedDelay(() -> {
                event.getHook().editOriginalEmbeds(b.setDescription(dtf.format(new Date(dateMill + aff[0]))).build()).queue();
                aff[0] += 2120;
            }, 2, 2, TimeUnit.SECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}