package com.example.airbnbbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameHouse;
    private int bedroom;
    private int bathroom;
    private double voteNumber;
    private double priceHouse;


    @OneToMany(mappedBy = "house")
    private List<ImageHouse> imageHouses;

    @ManyToMany
    @JoinTable(
            name = "house_house_type",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "house_type_id"))
    private List<HouseType> houseTypes;

    @ManyToMany
    @JoinTable(
            name = "house_room_type",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "room_type_id"))
    private List<RoomType> roomTypes;


    @OneToOne(mappedBy = "house")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
