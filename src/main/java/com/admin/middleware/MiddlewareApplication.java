package com.admin.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

}
