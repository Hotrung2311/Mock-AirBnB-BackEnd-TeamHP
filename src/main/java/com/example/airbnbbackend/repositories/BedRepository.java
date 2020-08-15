package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed,Long> {
}
