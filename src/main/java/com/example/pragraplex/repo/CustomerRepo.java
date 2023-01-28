package com.example.pragraplex.repo;

import com.example.pragraplex.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByLastName(String lastName);

    @Query("select c from Customer c where len(c.login) < :length ")
    //@Query(value = "SELECT * FROM TABLE_CUSTOMER C WHERE LEN(C.LOGIN) = :length", nativeQuery = true)
    List<Customer> withLoginLessThanN(int length);

}
