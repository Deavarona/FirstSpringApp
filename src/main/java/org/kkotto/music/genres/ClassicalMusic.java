package org.kkotto.music.genres;

import org.kkotto.music.Music;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private List<String> playlist = List.of("Apashe - Overture", "Apashe - Lord&Master", "Apashe - Distance");

    @Override
    public int getNumberOfSongs() {
        return playlist.size();
    }

    @Override
    public String getSong(int songNumber) {
        return playlist.get(songNumber);
    }
}
