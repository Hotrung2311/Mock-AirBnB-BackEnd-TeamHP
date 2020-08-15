package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
    @Query(value="select")
}
