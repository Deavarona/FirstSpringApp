package org.kkotto.music.genres;

import org.kkotto.music.Music;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
}
