package edu.eci.arep.app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("!roundrobin")
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://admin:nico123@mongodb:27017"); // Asegúrate de que la URI de MongoDB es correcta
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "logdb"); // Reemplaza "your_database_name" con el nombre de tu base de datos
    }
}
