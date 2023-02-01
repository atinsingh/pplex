package com.example.pragraplex.rest;

import com.example.pragraplex.entity.Order;
import com.example.pragraplex.service.CustomerService;
import com.example.pragraplex.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// /api/customer/{id}/order
@RestController
@RequestMapping("/api/customer")
public class OrderApi {

    private final OrderService service;

    public OrderApi(OrderService service) {
        this.service = service;
    }

    @PostMapping("/{id}/order")
    public Order addOrder(@PathVariable("id") int customerId, @RequestBody Order order){
        return service.createOrder(customerId, order);
    }


    @GetMapping("/orders")
    public List<Order> getAll() {
        return service.finAll();
    }
}
