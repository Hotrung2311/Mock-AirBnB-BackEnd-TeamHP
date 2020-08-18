package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.Booking;
import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.service.BookingService;
import com.example.airbnbbackend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private HouseService houseService;

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        int startTimeYear = booking.getStartTime().getYear();
        int stopTimeYear = booking.getStopTime().getYear();
        int startTimeDay = booking.getStartTime().getDayOfYear();
        int stopTimeDay = booking.getStopTime().getDayOfYear();
        List<Booking> bookings = bookingService.findByHouse_Id(booking.getHouse().getId());
        LocalDate date = java.time.LocalDate.now();
        boolean checkTime = false;
        if (date.getYear() <= booking.getStartTime().getYear()
        && date.getDayOfYear()<booking.getStartTime().getDayOfYear()){
            if (startTimeYear==stopTimeYear){
                if (startTimeDay<stopTimeDay){
                    for (Booking value : bookings) {
                        if (startTimeYear == value.getStartTime().getYear()
                                && stopTimeYear == value.getStopTime().getYear()) {
                            if ((startTimeDay < value.getStartTime().getDayOfYear() &&
                                    stopTimeDay < value.getStartTime().getDayOfYear()) ||
                                    (startTimeDay > value.getStopTime().getDayOfYear() &&
                                            stopTimeDay > value.getStopTime().getDayOfYear())) {
                                checkTime = true;
                            } else {
                                checkTime = false;
                                break;
                            }
                        } else checkTime = true;
                    }
                }
            }
        }
        if (checkTime){
            bookingService.save(booking);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

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
       List<Booking> bookings = bookingService.findByAccount_Id(id);
       return ResponseEntity.ok(bookings);
   }
   @PostMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
       bookingService.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }

}
