package com.guru.kafka.api.server;

import com.guru.kafka.api.request.PromotionRequest;
import com.guru.kafka.broker.message.PromotionMessage;
import com.guru.kafka.command.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotion")
public class PromotionApi {

    @Autowired
    private PromotionService service;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody PromotionRequest request){
        service.createPromotion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request.getPromotionCode());
    }
}
