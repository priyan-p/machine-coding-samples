package com.example.demo.config;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public GameService gameService(Game game) {
        return new GameService(game);
    }

}
