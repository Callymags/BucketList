package com.bucketlist.project.experiences.microservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExperienceServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("EXPERIENCE_POSTGRES_USER", dotenv.get("EXPERIENCE_POSTGRES_USER"));
		System.setProperty("EXPERIENCE_POSTGRES_PASSWORD", dotenv.get("EXPERIENCE_POSTGRES_PASSWORD"));
		System.setProperty("EXPERIENCE_POSTGRES_DB", dotenv.get("EXPERIENCE_POSTGRES_DB"));


		SpringApplication.run(ExperienceServiceApplication.class, args);
	}

}
