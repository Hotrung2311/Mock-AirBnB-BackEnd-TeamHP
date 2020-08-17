package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCity;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
