package com.example.pragraplex.service;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.exceptions.UnsupportedLoginEmailException;
import com.example.pragraplex.exceptions.UnsupportedLoginNameException;
import com.example.pragraplex.repo.CustomerRepo;
import com.example.pragraplex.validation.CustomerValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo repo;

    public CustomerServiceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if(CustomerValidation.customerValidation(customer)) {
            return repo.save(customer);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return repo.findById(id);
    }

    public List<Customer> createAll(List<Customer> customers) {
        return repo.saveAll(customers);
    }

    public List<Customer> getByLastName(String lastName){
        List<Customer> customerByLastName = repo.findAllByLastName(lastName);
        return customerByLastName;
    }
}
