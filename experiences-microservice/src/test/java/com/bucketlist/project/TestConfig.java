package com.bucketlist.project;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import io.github.cdimascio.dotenv.Dotenv;

@TestConfiguration
public class TestConfig {

    @Bean
    public void setupEnvVariables() {
        Dotenv dotenv = Dotenv.configure().directory("../").load();
        System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
        System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));
        System.setProperty("POSTGRES_DB", dotenv.get("POSTGRES_DB"));

    }
}

