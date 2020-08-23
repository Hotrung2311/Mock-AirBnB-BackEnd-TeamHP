package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.model.ImageHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageHouseRepository extends JpaRepository<ImageHouse,Long> {
    List<ImageHouse> findAllByHouse(House house);
    List<ImageHouse> findAllByHouse_Id(Long id);
}
