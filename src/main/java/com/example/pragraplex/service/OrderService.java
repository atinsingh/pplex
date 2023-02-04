package com.example.pragraplex.service;

import com.example.pragraplex.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order createOrder(int custId, Order order, int movieId);
    Order createOrder(int custId, Order order);


    List<Order> finAll();
    Optional<Order> findOneById(UUID uuid);
}
