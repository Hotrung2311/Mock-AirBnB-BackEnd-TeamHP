package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Address;
import com.example.airbnbbackend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
//    Address findAllByApartment(House house);
}
