package com.guru.kafka;

import com.guru.kafka.producer.ImageProducer;
import com.guru.kafka.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerHandlingExceptionApplication implements CommandLineRunner {

  /*  @Autowired
    private FoodOrderProducer foodOrderProducer;

    @Autowired
    private SimpleNumberProducer simpleNumberProducer;*/

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageProducer imageProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerHandlingExceptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*var chickenOrder = new FoodOrder(3, "Chicken");
        var fishOrder = new FoodOrder(10, "Fish");
        var pizzaOrder = new FoodOrder(5, "Pizza");

        foodOrderProducer.send(chickenOrder);
        foodOrderProducer.send(fishOrder);
        foodOrderProducer.send(pizzaOrder);

        for (int i = 0; i < 10; i++) {
            var simpleNumber = new SimpleNumber();
            simpleNumberProducer.send(simpleNumber);
        }*/

        var image1 = imageService.generateImage("jpg");
        var image2 = imageService.generateImage("svg");
        var image3 = imageService.generateImage("png");
        var image4 = imageService.generateImage("gif");
        var image5 = imageService.generateImage("bmp");
        var image6 = imageService.generateImage("tiff");

        imageProducer.send(image1, 0);
        imageProducer.send(image2, 0);
        imageProducer.send(image3, 0);
        imageProducer.send(image4, 1);
        imageProducer.send(image5, 1);
        imageProducer.send(image6, 1);


    }
}
