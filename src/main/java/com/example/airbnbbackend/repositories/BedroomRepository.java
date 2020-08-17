package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Bedroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedroomRepository extends JpaRepository<Bedroom,Long> {
}
