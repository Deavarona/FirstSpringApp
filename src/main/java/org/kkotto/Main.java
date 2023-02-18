package org.kkotto;

import org.kkotto.config.SpringConfig;
import org.kkotto.music.genres.Genre;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic(Genre.RAP);
        System.out.println("Volume of " + musicPlayer.getName() + " is " + musicPlayer.getVolume());
        context.close();
    }
}
