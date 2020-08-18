package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.RoomType;
import org.springframework.stereotype.Service;

public interface RoomTypeService {

    ServiceResult createRoomType(RoomType roomType);

    ServiceResult findAll();

    ServiceResult findById(Long id);

    ServiceResult deleteRoomType(Long id);

    ServiceResult updateRoomType(RoomType roomType);
}
