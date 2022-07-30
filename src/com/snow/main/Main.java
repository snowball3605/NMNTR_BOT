package com.snow.main;

import com.snow.main.comm.list.help;
import com.snow.main.comm.list.help2;
import com.snow.main.event.onready;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

import static com.snow.main.util.CommandOption.*;

public class Main {



    static final String TOKEN = "ODY5MTUwMjM1MDczNjAxNTM3.Gxo-C7.fqlNeLtrNgdFUPXCDieMxx4rlImkPDIWD-qr0M";

    public static JDA jda;
    public static String botID;
    public static Guild guild;

    public static void main(String[] args) throws Exception {

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN)
                .setLargeThreshold(250)
                .enableCache(CacheFlag.ONLINE_STATUS, CacheFlag.ACTIVITY)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.playing("賽馬娘"))
                .setStatus(OnlineStatus.OFFLINE)
                .addEventListeners(new com.snow.main.Listener());


        jda = jdaBuilder.build().awaitReady();
        jda.addEventListener(new onready());
        jda.addEventListener(new help());
        jda.addEventListener(new help2());
        botID = jda.getSelfUser().getId();
        guild = jda.getGuildById("825162735603810316");


        jda.getGuildById("825162735603810316").updateCommands().addCommands(
                new CommandDataImpl("invite", "邀請別人"),
                new CommandDataImpl("kick", "剔除成員")
                        .addOption(OptionType.MENTIONABLE, "member", "要踢誰", true),
                new CommandDataImpl("ban", "封鎖成員")
                        .addOption(OptionType.USER, BANMEMBER, "e", true)
                        .addOption(OptionType.INTEGER, DELDAYS, "BAN_DAY[1-7Day]"),
                new CommandDataImpl("unban", "解除封鎖")
                        .addOption(OptionType.STRING, USERID, "要解封誰", true),
                new CommandDataImpl("clear", "清除訊息[1-100]")
                        .addOption(OptionType.INTEGER, COUNT, "清除訊息", true),
                new CommandDataImpl("countdown", "countdown")
                        .addOption(OptionType.INTEGER, SECONDS, "seconds", true)
                        .addOption(OptionType.INTEGER, MINUTE, "minute")
                        .addOption(OptionType.INTEGER, HOUR, "hour")
                        .addOption(OptionType.INTEGER, DAYS, "days"),
                new CommandDataImpl("play", "play music"),
                new CommandDataImpl("help", "查看機械人教學"),
                new CommandDataImpl("ping", "延遲測試"),
                new CommandDataImpl("reload", "reload bot"),
                new CommandDataImpl("test", "test"),
                new CommandDataImpl("question", "question"),
                new CommandDataImpl("recreate", "重新創建頻道")

        ).queue();
    }
}
// ok thx