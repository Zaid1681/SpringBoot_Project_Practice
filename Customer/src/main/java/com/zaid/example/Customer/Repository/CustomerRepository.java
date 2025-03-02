package com.zaid.example.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zaid.example.Customer.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//	Optional<Employee> findByFirstNameIgnoreCase(String firstName);
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Optional<Customer> findByEmail(@Param("email") String email);

}
