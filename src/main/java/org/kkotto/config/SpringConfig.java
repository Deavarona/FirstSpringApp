package org.kkotto.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.kkotto")
@PropertySource("classpath:player.properties")
public class SpringConfig {
}
