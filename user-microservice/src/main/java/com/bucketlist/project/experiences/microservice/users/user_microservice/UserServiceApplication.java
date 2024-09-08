package com.bucketlist.project.experiences.microservice.users.user_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("USER_POSTGRES_USER", dotenv.get("USER_POSTGRES_USER"));
		System.setProperty("USER_POSTGRES_PASSWORD", dotenv.get("USER_POSTGRES_PASSWORD"));
		System.setProperty("USER_POSTGRES_DB", dotenv.get("USER_POSTGRES_DB"));

		SpringApplication.run(UserServiceApplication.class, args);
	}
}