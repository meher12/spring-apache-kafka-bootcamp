package com.guru.kafka;

import com.guru.kafka.entity.PaymentRequest;
import com.guru.kafka.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {


    @Autowired
    private PaymentRequestProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaCoreProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var paymentRequestAlpha_Transaction1 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes alpha", "Budget reserve");
        var paymentRequestAlpha_Transaction2 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes alpha", "Approval workflow");
        var paymentRequestAlpha_Transaction3 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes alpha", "Push notification");

        var paymentRequestBeta_Transaction1 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes beta", "Budget reserve");
        var paymentRequestBeta_Transaction2 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes beta", "Approval workflow");
        var paymentRequestBeta_Transaction3 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes beta", "Push notification");

        producer.send(paymentRequestAlpha_Transaction1);
        producer.send(paymentRequestAlpha_Transaction2);
        producer.send(paymentRequestAlpha_Transaction3);

        producer.send(paymentRequestBeta_Transaction1);
        producer.send(paymentRequestBeta_Transaction2);
        producer.send(paymentRequestBeta_Transaction3);

        producer.send(paymentRequestAlpha_Transaction2);
        producer.send(paymentRequestAlpha_Transaction3);



    }
}
