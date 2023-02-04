package com.example.pragraplex.service;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.entity.Order;
import com.example.pragraplex.exceptions.CustomerNotFoundException;
import com.example.pragraplex.exceptions.MovieNotFoundException;
import com.example.pragraplex.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo repo;
    private final CustomerService customerService;
    private final MovieService movieService;

    public Order createOrder(int custId, Order order){
        Optional<Customer> customerById = customerService.getCustomerById(custId);
        Optional<Movie> movieById = movieService.getMovieByID(order.getMovie().getId());
        log.debug("Customer id {} provided to crate order", custId);
        Movie movie= movieById.orElseThrow(
                ()->new MovieNotFoundException(String.format("Moview with Id: %d not found", order.getMovie().getId())));
        Customer customer =
                customerById.orElseThrow(
                        ()-> new CustomerNotFoundException(String.format("Customer with id %d not found", custId))
                );

            order.setMovie(movieById.get());
            order.setCustomer(customerById.get());
            return repo.save(order);

    }

    public Order createOrder(int custId, Order order, int movieId){
        Optional<Customer> customerById = customerService.getCustomerById(custId);
        Optional<Movie> movieById = movieService.getMovieByID(movieId);
        if (customerById.isPresent() && movieById.isPresent()) {
            order.setMovie(movieById.get());
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
