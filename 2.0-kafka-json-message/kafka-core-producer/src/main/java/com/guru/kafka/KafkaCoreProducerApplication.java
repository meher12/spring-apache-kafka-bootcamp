package com.guru.kafka;

import com.guru.kafka.entity.Employee;
import com.guru.kafka.producer.EmployeeJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class KafkaCoreProducerApplication implements CommandLineRunner {

	@Autowired
	private EmployeeJsonProducer jsonProducer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
            var emp = new Employee("emp-" + i, "Employee " + i, LocalDate.now());
			jsonProducer.sendMessage(emp);
		}

	}
}
