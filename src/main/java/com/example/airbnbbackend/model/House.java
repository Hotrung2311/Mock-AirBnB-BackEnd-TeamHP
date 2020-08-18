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
    private int bathroom;
    private int bedroom;
    private double priceHouse;
    private double voteNumber;

    @OneToMany(mappedBy = "house")
    private List<ImageHouse> imageHouses;

    @OneToMany(mappedBy = "house")
    private List<Booking> bookings;

    @OneToOne(mappedBy = "house")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @ManyToMany
    @JoinTable(
            name = "house_housetype",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "house_type_id"))
    private List<HouseType> houseTypes;

    @ManyToMany
    @JoinTable(
            name = "house_roomtype",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "room_type_id"))
    private List<RoomType> roomTypes;

//    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;

}
