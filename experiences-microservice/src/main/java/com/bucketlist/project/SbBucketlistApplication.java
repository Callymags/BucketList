package com.bucketlist.project;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbBucketlistApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
		System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));
		System.setProperty("POSTGRES_DB", dotenv.get("POSTGRES_DB"));


		SpringApplication.run(SbBucketlistApplication.class, args);
	}

}
