package com.guru.kafka.broker.consumer;

import com.guru.kafka.broker.message.DiscountMessage;
import com.guru.kafka.broker.message.PromotionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "t-commodity-promotion")
public class PromotionConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(PromotionConsumer.class);

    @KafkaHandler
    public void listenPromotion(@Payload PromotionMessage message) {
        LOG.info("Processing promotion : {}", message);
    }

    @KafkaHandler
    public void listenDiscount(@Payload DiscountMessage message) {
        LOG.info("Processing discount : {}", message);
    }

}
