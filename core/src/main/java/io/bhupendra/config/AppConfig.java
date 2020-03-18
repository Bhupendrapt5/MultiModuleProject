package io.bhupendra.config;

import io.bhupendra.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "io.bhupendra")
public class AppConfig {
    //=== bean methods ===
//    @Bean
//    public NumberGenerator numberGenerator(){
//        return new NumberGeneratorImpl();
//    }

//    @Bean
//    public Game game(){
//        return new GameImpl();
//    }

//    @Bean
//    public MessageGenerator messageGenerator(){
//        return new MessageGeneratorImpl();
//    }
}
