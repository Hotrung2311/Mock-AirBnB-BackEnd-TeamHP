package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.models.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Types, Long> {
    Types findByName(String username);
}
