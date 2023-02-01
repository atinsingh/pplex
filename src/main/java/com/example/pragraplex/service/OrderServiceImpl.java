package com.example.pragraplex.service;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.entity.Order;
import com.example.pragraplex.exceptions.CustomerNotFoundException;
import com.example.pragraplex.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo repo;
    private final CustomerService customerService;

    public Order createOrder(int custId, Order order){
        Optional<Customer> customerById = customerService.getCustomerById(custId);
        if (customerById.isPresent()) {
           order.setCustomer(customerById.get());
           return repo.save(order);
        }else {
            throw new CustomerNotFoundException(String.format("Customer with id %d not found", custId));
        }

    }

    public List<Order> finAll(){
        return repo.findAll();
    }

    public Optional<Order> findOneById(UUID uuid) {
        return repo.findById(uuid);
    }


}
