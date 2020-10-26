/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.ieti.data.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author AndrésQuintero
 */
@Configuration
public class AppConfiguration {

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://ieti_user:ieti2020@cluster0.xpuez.mongodb.net/ietidb?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        return new SimpleMongoDbFactory(mongoClient, "ietidb");

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

}
