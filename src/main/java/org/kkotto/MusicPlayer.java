package org.kkotto;

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
        this.musicList = musicList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}
