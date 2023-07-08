package com.guru.kafka;

import com.guru.kafka.producer.Image2Producer;
import com.guru.kafka.producer.ImageProducer;
import com.guru.kafka.producer.InvoiceProducer;
import com.guru.kafka.service.ImageService;
import com.guru.kafka.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerHandlingExceptionApplication implements CommandLineRunner {

  /*  @Autowired
    private FoodOrderProducer foodOrderProducer;

    @Autowired
    private SimpleNumberProducer simpleNumberProducer;*/

   /* @Autowired
    private ImageService imageService;

    @Autowired
    private Image2Producer image2Producer;
*/
   /* @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceProducer invoiceProducer;*/

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

         /* for (int i = 0; i < 10; i++) {
            var invoice = invoiceService.generateInvoice();

            if(i>5){
                invoice.setAmount(0);
            }
            invoiceProducer.send(invoice);
        }*/

     /*   var image1 = imageService.generateImage("jpg");
        var image2 = imageService.generateImage("svg");
        var image3 = imageService.generateImage("gif");
        var image4 = imageService.generateImage("gif");
        var image5 = imageService.generateImage("gif");
        var image6 = imageService.generateImage("gif");

        image2Producer.send(image1, 0);
        image2Producer.send(image2, 0);
        image2Producer.send(image3, 0);
        image2Producer.send(image4, 1);
        image2Producer.send(image5, 1);
        image2Producer.send(image6, 1);*/




    }
}
