package com.guru.kafka.api.server;

import com.guru.kafka.api.response.OrderResponse;
import com.guru.kafka.command.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        // 1. save order using service
        var orderNumber = orderService.saveOrder(request);

        // 2. create response
        var orderResponse = new OrderResponse(orderNumber);

        // 3. return response
        return ResponseEntity.ok().body(orderResponse);
    }
}
