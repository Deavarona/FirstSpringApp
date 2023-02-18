package org.kkotto.music.genres;

import org.kkotto.music.Music;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RapMusic implements Music {
    private List<String> playlist = List.of("Monster", "Madness", "Undead");

    @Override
    public int getNumberOfSongs() {
        return playlist.size();
    }

    @Override
    public String getSong(int songNumber) {
        return playlist.get(songNumber);
    }

    @PostConstruct
    private void init() {
        System.out.println("Rap started");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Rap finished");
    }
}
