package org.kkotto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application.xml"
        );
        MusicPlayer musicPlayer = new MusicPlayer();
        Music classicalMusic = context.getBean("classicalMusic", Music.class);
        Music rapMusic = context.getBean("rapMusic", Music.class);
        Music rockMusic = context.getBean("rockMusic", Music.class);
        musicPlayer.setMusicList(List.of(classicalMusic, rockMusic, rapMusic));
        musicPlayer.playMusic();
        context.close();
    }
}
