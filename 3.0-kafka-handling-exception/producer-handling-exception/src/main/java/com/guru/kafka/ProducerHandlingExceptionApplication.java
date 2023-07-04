package com.guru.kafka;

import com.guru.kafka.entity.FoodOrder;
import com.guru.kafka.entity.SimpleNumber;
import com.guru.kafka.producer.FoodOrderProducer;
import com.guru.kafka.producer.SimpleNumberProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerHandlingExceptionApplication implements CommandLineRunner {

    @Autowired
    private FoodOrderProducer foodOrderProducer;

    @Autowired
    private SimpleNumberProducer simpleNumberProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerHandlingExceptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var chickenOrder = new FoodOrder(3, "Chicken");
        var fishOrder = new FoodOrder(10, "Fish");
        var pizzaOrder = new FoodOrder(5, "Pizza");

        foodOrderProducer.send(chickenOrder);
        foodOrderProducer.send(fishOrder);
        foodOrderProducer.send(pizzaOrder);

        for (int i = 0; i < 10; i++) {
            var simpleNumber = new SimpleNumber();
            simpleNumberProducer.send(simpleNumber);
        }
    }
}
