package com.guru.kafka;

import com.guru.kafka.producer.HelloKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class KafkaCoreProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloKafkaProducer producer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      producer.sendHello("Timeus" + ThreadLocalRandom.current().nextInt());
	}
}
