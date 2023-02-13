package org.kkotto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application.xml"
        );
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer second = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.setVolume(10);
        System.out.println((musicPlayer == second));
        System.out.println(musicPlayer.getVolume() + " and " + second.getVolume());
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        context.close();
    }
}
