package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.Booking;
import com.example.airbnbbackend.repositories.BookingRepository;
import com.example.airbnbbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Optional<Booking> findByAccount_IdAndHouse_Id(Long account_id, Long house_id) {
        return bookingRepository.findByAccount_IdAndHouse_Id(account_id,house_id);
    }

    @Override
    public List<Long> getCompareStartTimeList( Long id) {
        return bookingRepository.getCompareStartTimeList(id);
    }

    @Override
    public List<Booking> findByHouse_Id(Long id) {
        return bookingRepository.findByHouse_Id(id);
    }

    @Override
    public List<Booking> findByAccount_Id(Long id) {
        return bookingRepository.findByAccount_Id(id);
    }
}
