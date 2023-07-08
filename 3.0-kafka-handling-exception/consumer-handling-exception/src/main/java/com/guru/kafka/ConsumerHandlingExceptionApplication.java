package com.guru.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerHandlingExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHandlingExceptionApplication.class, args);
	}

}
