package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.Address;
import com.example.airbnbbackend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {

    List<House> findByAccount_Id(Long id);

    @Query(value = "select * from demo.house ",nativeQuery = true)
    List<House> findAllHouse();

    Optional<House> findByAddress(Address address);

    // bang add

//    List<House> findApartmentByBedroomAndBathroomAndAddress_Province_Id(int bedroom,int bathroom,Long province_id);

//    List<House> findAllByUser(Account account);

}
