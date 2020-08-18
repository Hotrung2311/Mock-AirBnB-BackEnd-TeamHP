package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Booking;
import com.example.airbnbbackend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    void save(Booking booking);

    void delete(Long id);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    Optional<Booking> findByAccount_IdAndHouse_Id(Long account_id, Long house_id);

    List<Long> getCompareStartTimeList( Long id);

    List<Booking> findByHouse_Id(Long id);

    List<Booking> findByAccount_Id(Long id);

}
