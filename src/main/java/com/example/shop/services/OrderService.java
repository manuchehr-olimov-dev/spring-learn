//package com.example.shop.services;
//
//import com.example.shop.controllers.requests.CreateOrderRequest;
//import com.example.shop.entities.OrderEntity;
//import com.example.shop.entities.UserEntity;
//import com.example.shop.repositories.OrderRepository;
//import com.example.shop.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.net.InetAddress;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class OrderService {
//
//    private final OrderRepository orderRepository;
//
//    private final UserRepository userRepository;
//
//    public ResponseEntity<OrderEntity> create(CreateOrderRequest request) {
//
//        UserEntity user = userRepository.findById(request.getUserId()).get();
//        OrderEntity newOrder = new OrderEntity();
//
//        newOrder.setName(request.getName());
//        newOrder.setPrice(request.getPrice());
//        newOrder.setIsPaid(request.isPaid());
//        newOrder.setUser(user);
//        user.getOrders().add(newOrder);
//        orderRepository.save(newOrder);
//
//        return ResponseEntity.ok(newOrder);
//    }
//}
