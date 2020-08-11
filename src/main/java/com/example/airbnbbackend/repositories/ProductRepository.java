package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Products findByName(String username);
}
