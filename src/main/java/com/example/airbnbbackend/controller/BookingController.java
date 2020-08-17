package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.Booking;
import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.service.BookingService;
import com.example.airbnbbackend.service.HouseService;
import com.example.airbnbbackend.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private HouseService houseService;

//    @PostMapping("/create")
//    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
////        List<Booking> bookings = bookingService.findByHouse_Id();
////        System.out.println(bookings);
////        bookingService.save(booking);
////        return new ResponseEntity<>(HttpStatus.OK);
//    }

   @GetMapping("/host/{id}")
    public ResponseEntity<?> historyBookingForHost(@PathVariable Long id){
        List<Booking> bookings = new ArrayList<>();
        List<House> houses = houseService.findAllHouse(id);
       for (House house : houses) {
           List<Booking> bookings1 = bookingService.findByHouse_Id(house.getId());
           bookings.addAll(bookings1);
       }
        return ResponseEntity.ok(bookings);
   }

   @GetMapping("/{id}")
    public ResponseEntity<?> historyBookingForCustomer(@PathVariable Long id){
       List<Booking> bookings = bookingService.findByHouse_Id(id);
       return ResponseEntity.ok(bookings);
   }
   @PostMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
       bookingService.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }

}
