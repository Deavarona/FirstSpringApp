package org.kkotto;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList;
    private String name;
    private int volume;

    public void playMusic() {
        for (Music music : this.musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = new ArrayList<>(musicList);
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
