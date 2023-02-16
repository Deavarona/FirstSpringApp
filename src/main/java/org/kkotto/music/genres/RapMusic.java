package org.kkotto.music.genres;

import org.kkotto.music.Music;
import org.springframework.stereotype.Component;

@Component
public class RapMusic implements Music {
    @Override
    public String getSong() {
        return "Morgenstern";
    }
}
