package com.bucketlist.project;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BucketlistServiceApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		// Set environment variables as system properties
		System.setProperty("BUCKETLIST_POSTGRES_USER", dotenv.get("BUCKETLIST_POSTGRES_USER"));
		System.setProperty("BUCKETLIST_POSTGRES_PASSWORD", dotenv.get("BUCKETLIST_POSTGRES_PASSWORD"));
		System.setProperty("BUCKETLIST_POSTGRES_DB", dotenv.get("BUCKETLIST_POSTGRES_DB"));

		// Run the Spring Boot application
		SpringApplication.run(BucketlistServiceApplication.class, args);
	}
}
