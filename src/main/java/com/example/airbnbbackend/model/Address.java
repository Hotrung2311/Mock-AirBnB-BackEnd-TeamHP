package com.example.airbnbbackend.model;

import com.example.airbnbbackend.model.City;
import com.example.airbnbbackend.model.House;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;
}
