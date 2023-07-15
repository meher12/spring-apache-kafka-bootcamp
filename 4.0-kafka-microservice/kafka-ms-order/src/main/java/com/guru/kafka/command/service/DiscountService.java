package com.guru.kafka.command.service;

import com.guru.kafka.api.request.DiscountRequest;

import com.guru.kafka.command.action.DiscountAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountAction action;

    public void createDiscount(DiscountRequest request) {
        action.publishToKafka(request);
    }
}
