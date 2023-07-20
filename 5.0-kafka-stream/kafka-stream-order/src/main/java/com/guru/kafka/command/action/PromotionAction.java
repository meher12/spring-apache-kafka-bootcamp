package com.guru.kafka.command.action;

import com.guru.kafka.api.request.PromotionRequest;
import com.guru.kafka.broker.message.PromotionMessage;
import com.guru.kafka.broker.producer.PromotionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PromotionAction {

	@Autowired
	private PromotionProducer producer;
	
	public void publishToKafka(PromotionRequest request) {
		var message = new PromotionMessage(request.getPromotionCode());
		
		producer.publish(message);
	}

}
