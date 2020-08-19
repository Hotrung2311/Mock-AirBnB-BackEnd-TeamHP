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
    private double priceHouse;
    private double voteNumber;
//    private String roomTypes;
//    private String houseTypes;

    @ManyToMany
    @JoinTable(
            name = "house_houseType",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "houseType_id"))
    private List<HouseType> houseTypeList;

    @ManyToMany
    @JoinTable(
            name = "house_roomType",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "roomType_id"))
    private List<RoomType> roomTypeList;

    @OneToMany(mappedBy = "house")
    private List<ImageHouse> imageHouseList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;



}
