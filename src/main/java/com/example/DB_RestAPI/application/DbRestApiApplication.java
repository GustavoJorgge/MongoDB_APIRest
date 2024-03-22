package com.example.DB_RestAPI.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.DB_RestAPI.repository")
public class DbRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbRestApiApplication.class, args);
	}
}