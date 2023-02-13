package org.kkotto.MusicGenres;

import org.kkotto.Music;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public void initMethod() {
        System.out.println("hello summer");
    }

    public void destroyMethod() {
        System.out.println("bye sadness");
    }
}
