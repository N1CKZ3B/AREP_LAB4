package edu.eci.arep.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public MongoProperties mongoProperties() {
        return new MongoProperties();
    }
}
