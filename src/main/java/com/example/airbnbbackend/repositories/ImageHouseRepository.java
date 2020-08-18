package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.ImageHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageHouseRepository extends JpaRepository<ImageHouse,Long> {
    ImageHouse findRoleByImageName(String name);
}
