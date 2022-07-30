package com.snow.main;

import com.snow.main.comm.list.*;
import com.snow.main.event.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class Listener extends ListenerAdapter {
    Ip ip = new Ip();
    Invite invite = new Invite();
    JoinAndLeaveMain joinAndLeaveMain = new JoinAndLeaveMain();
    Kick kick = new Kick();
    Ban ban = new Ban();
    Unban unban = new Unban();
    onGuildVoiceJoin onGuildVoiceJoin = new onGuildVoiceJoin();
    onGuildVoiceLeave onGuildVoiceLeave = new onGuildVoiceLeave();
    onready onready = new onready();
    clear clear = new clear();
    time time = new time();
    onGuildVoiceMove onGuildVoiceMove = new onGuildVoiceMove();
    play play = new play();
    help help = new help();
    help2 help2 = new help2();
    ping ping = new ping();
    reload reload = new reload();
    JoinAndLevelOtt ott = new JoinAndLevelOtt();
    test test = new test();
    Question question = new Question();
    Question_button_click question_button_click = new Question_button_click();
    vote vote = new vote();
    recreate recreate = new recreate();

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        joinAndLeaveMain.GuildReactionCheck(event);
        joinAndLeaveMain.GuildReactionCheck1(event);
        joinAndLeaveMain.GuildReactionCheck2(event);

    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        invite.onSlashCommand(event);
        recreate.onSlashCommand(event);
        kick.onSlashCommand(event);
        ban.onSlashCommand(event);
        unban.onSlashCommand(event);
        clear.onSlashCommand(event);
        time.onSlashCommand(event);
        help.onSlashCommand(event);
        ping.onSlashCommand(event);
        reload.onSlashCommand(event);
        question.onSlashCommand(event);
        test.onSlashCommand(event);

    }
    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        help2.SelectMenu(event);
        question_button_click.SelectMen(event);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (JoinAndLeaveMain.Step.step == 4) {
            joinAndLeaveMain.onMessage(event);
        }
        if (event.isFromGuild())
            invite.onCommand(event);
            ip.onMessageReceived(event);

    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        joinAndLeaveMain.onJoin(event);
        System.out.println("Join");
    }


    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        System.out.println("Leave");
        joinAndLeaveMain.onLeave(event);
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        onGuildVoiceJoin.onVoiceJoin(event);
    }
    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        onGuildVoiceLeave.onVoiceLeave(event);
    }
    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        onGuildVoiceMove.onVoiceMove(event); }
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        onready.onReady(event);}
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        question_button_click.onButtonClick(event);
        question_button_click.onButtonClick1(event);
        question_button_click.onButtonClick2(event);
        question_button_click.onButtonClick3(event);
    }

}
