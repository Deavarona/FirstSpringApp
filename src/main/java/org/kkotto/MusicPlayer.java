package org.kkotto;

import org.kkotto.music.Music;
import org.kkotto.music.genres.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private Music classicalPlaylist;
    private Music rockPlaylist;
    private Music rapPlaylist;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalPlaylist,
                       @Qualifier("rockMusic") Music rockPlaylist,
                       @Qualifier("rapMusic") Music rapPlaylist) {
        this.classicalPlaylist = classicalPlaylist;
        this.rockPlaylist = rockPlaylist;
        this.rapPlaylist = rapPlaylist;
    }

    public void playMusic(Genre genre) {
        System.out.println("Playing: " + chooseSong(choosePlaylist(genre)));
    }

    private Music choosePlaylist(Genre genre) {
        return switch (genre) {
            case CLASSICAL -> classicalPlaylist;
            case RAP -> rapPlaylist;
            case ROCK -> rockPlaylist;
        };
    }

    private String chooseSong(Music currentPlaylist) {
        Random fate = new Random();
        int songNumber = fate.nextInt(currentPlaylist.getNumberOfSongs());
        return currentPlaylist.getSong(songNumber);
    }
}
