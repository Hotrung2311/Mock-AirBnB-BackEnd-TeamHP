package com.example.airbnbbackend.model;

import lombok.Data;

@Data
public class BookingRequest {
    private Long id;
    private Long startTime;
    private Long endTime;
    private Account account;
    private House house;
}
