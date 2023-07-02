package com.guru.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateConsumer {

    public static final Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);

    @KafkaListener(topics = "t-fixedrate")
    public void consumer(String message){
        LOG.info("Consuming: {}", message);
    }
}
