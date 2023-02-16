package org.kkotto.music.genres;

import org.kkotto.music.Music;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RockMusic implements Music {
    private List<String> playlist = List.of("Emil Bulls - Man or Mouse", "Emil Bulls - In Any Case Maybe",
            "Emil Bulls - You should see me in a crown");

    @Override
    public int getNumberOfSongs() {
        return playlist.size();
    }

    @Override
    public String getSong(int songNumber) {
        return playlist.get(songNumber);
    }
}
