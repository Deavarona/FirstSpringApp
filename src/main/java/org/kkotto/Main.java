package org.kkotto;

import org.kkotto.MusicGenres.ClassicalMusic;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application.xml"
        );
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer copy = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());
        context.close();
    }
}
