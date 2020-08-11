package com.example.airbnbbackend.repositoies;

import com.example.airbnbbackend.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Details, Long> {
}
