package org.kkotto.genres;

import org.kkotto.Music;
import org.springframework.stereotype.Component;

@Component
public class RapMusic implements Music {
    @Override
    public String getSong() {
        return "Morgenstern";
    }
}
