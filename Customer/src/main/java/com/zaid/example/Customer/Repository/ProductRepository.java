package com.zaid.example.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.example.Customer.Entity.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

}
