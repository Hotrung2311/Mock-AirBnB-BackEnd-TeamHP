package com.example.airbnbbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCity;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<House> houseList;
}
