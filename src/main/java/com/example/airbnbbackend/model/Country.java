package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCountry;

}
