package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp startTime;
    private Timestamp stopTime;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}
