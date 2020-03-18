package io.bhupendra.config;

import io.bhupendra.GuessCount;
import io.bhupendra.MaxNumber;
import io.bhupendra.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    //== fields ===
    @Value("${game.maxNumber: 50}")
    private int maxNumber;

    @Value("${game.guessCount: 8}")
    private int guessCount ;


    @Value("${game.minNumber: 5}")
    private int minNumber ;


    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int MinNumber(){
        return minNumber;
    }
}
