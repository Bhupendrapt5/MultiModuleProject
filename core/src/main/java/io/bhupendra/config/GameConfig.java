package io.bhupendra.config;

import io.bhupendra.GuessCount;
import io.bhupendra.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    //== fields ===
    private int maxNumber = 50 ;

    private int guessCount = 8;

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
}
