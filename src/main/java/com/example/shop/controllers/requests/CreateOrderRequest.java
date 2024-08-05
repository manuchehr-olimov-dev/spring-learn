package com.example.shop.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {
    private Long userId;
    private String name;
    private Double price;
    private boolean isPaid;
}
