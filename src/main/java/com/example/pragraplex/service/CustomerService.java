package com.example.pragraplex.service;

import com.example.pragraplex.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
     Customer createCustomer(Customer customer);
     List<Customer> getAllCustomer();
     Optional<Customer> getCustomerById(Integer id);
     List<Customer> getByLastName(String lastName);
     List<Customer> createAll(List<Customer> customers);
}
