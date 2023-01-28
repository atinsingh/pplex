package com.example.pragraplex.rest;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerApi {

    private CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> getAll(@RequestParam(name = "lastName", required = false, defaultValue = "abc") String lastName){

        if(lastName.equals("abc")){
            return customerService.getAllCustomer();
        }
        return customerService.getByLastName(lastName);

    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
        return customerService.createCustomer(customer);
    }

    @PostMapping("/customers")
    public List<Customer> createAll(@RequestBody List<Customer> customers) {
        return customerService.createAll(customers);
    }

    @GetMapping("/customer/{id}")

    public Optional<Customer> getByID(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
}
