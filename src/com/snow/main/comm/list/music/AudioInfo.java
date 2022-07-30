package com.snow.main.comm.list.music;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.lang.ref.PhantomReference;
import net.dv8tion.jda.api.entities.Member;

public class AudioInfo {

    private final AudioTrack TRACK;
    private final Member AUTHOR;

    public AudioInfo(AudioTrack track, Member author) {
        this.TRACK = track;
        this.AUTHOR = author;
    }

    public AudioTrack getTRACK() {
        return TRACK;
    }

    public Member getAuthor() {
        return AUTHOR;
    }

}
