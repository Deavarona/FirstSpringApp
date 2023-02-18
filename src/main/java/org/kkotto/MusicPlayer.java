package org.kkotto;

import org.kkotto.music.Music;
import org.kkotto.music.genres.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MusicPlayer {
    private Music classicalPlaylist;
    private Music rockPlaylist;
    private Music rapPlaylist;
    @Value("${musicPlayer.volume}")
    private int volume;
    @Value("${musicPlayer.name}")
    private String name;

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

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    @PostConstruct
    private void init() {
        System.out.println("Player opened");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Player closed");
    }
}
