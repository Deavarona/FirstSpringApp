package org.kkotto;

import org.kkotto.music.genres.ClassicalMusic;
import org.kkotto.music.genres.RapMusic;
import org.kkotto.music.genres.RockMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RapMusic rapMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RapMusic rapMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rapMusic = rapMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusic() {
        System.out.println("Playing: " + classicalMusic.getSong());
        System.out.println("Playing: " + rapMusic.getSong());
        System.out.println("Playing: " + rockMusic.getSong());
    }

    public void setClassicalMusic(ClassicalMusic classicalMusic) {
        this.classicalMusic = classicalMusic;
    }

    public void setRapMusic(RapMusic rapMusic) {
        this.rapMusic = rapMusic;
    }

    public void setRockMusic(RockMusic rockMusic) {
        this.rockMusic = rockMusic;
    }
}
