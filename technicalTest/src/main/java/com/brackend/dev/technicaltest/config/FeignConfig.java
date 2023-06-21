package com.brackend.dev.technicaltest.config;

import com.brackend.dev.technicaltest.exception.StashErrorDecoder;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public StashErrorDecoder state(){
        return new StashErrorDecoder();
    }
}
