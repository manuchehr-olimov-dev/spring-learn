package com.example.shop.controllers;

import com.example.shop.controllers.requests.CreateOrderRequest;
import com.example.shop.entities.OrderEntity;
import com.example.shop.entities.UserEntity;
import com.example.shop.repositories.OrderRepository;
import com.example.shop.repositories.UserRepository;
import com.example.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<OrderEntity> create(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(orderService.create(request).getBody());
    }

}
