package com.guru.kafka.broker.consumer;


import com.guru.kafka.broker.message.OrderReplyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderReplyConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(OrderReplyConsumer.class);

    @KafkaListener(topics = "t-commodity-order-reply")
    public void listen(OrderReplyMessage message) {
        LOG.info("Reply message received : {}", message);
    }

}
