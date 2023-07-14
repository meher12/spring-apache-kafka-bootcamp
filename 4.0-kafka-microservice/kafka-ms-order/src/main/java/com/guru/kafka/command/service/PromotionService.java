package com.guru.kafka.command.service;

import com.guru.kafka.api.request.PromotionRequest;
import com.guru.kafka.command.action.PromotionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    @Autowired
    private PromotionAction action;

    public void createPromotion(PromotionRequest request){
        action.publishToKafka(request);
    }
}
