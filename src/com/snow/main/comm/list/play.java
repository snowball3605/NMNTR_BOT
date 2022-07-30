package com.snow.main.comm.list;


import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.snow.main.comm.list.music.TrackScheduler;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class play {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
            AudioSourceManagers.registerRemoteSources(playerManager);

            AudioPlayer player = playerManager.createPlayer();

            TrackScheduler trackScheduler = new TrackScheduler(player);
            player.addListener(trackScheduler);


            } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
