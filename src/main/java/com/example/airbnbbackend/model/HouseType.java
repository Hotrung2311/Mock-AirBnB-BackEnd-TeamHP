//package com.example.airbnbbackend.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//public class HouseType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//
//    @ManyToMany(mappedBy = "houseTypeList")
//    @JsonBackReference
//    private List<House> houseList;
//}
