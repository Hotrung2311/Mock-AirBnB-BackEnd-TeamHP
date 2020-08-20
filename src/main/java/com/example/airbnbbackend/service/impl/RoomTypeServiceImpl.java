//package com.example.airbnbbackend.service.impl;
//
//import com.example.airbnbbackend.model.RoomType;
//import com.example.airbnbbackend.repositories.HouseRepository;
//import com.example.airbnbbackend.repositories.RoomTypeRepository;
//import com.example.airbnbbackend.service.RoomTypeService;
//import com.example.airbnbbackend.service.ServiceResult;
//import com.example.airbnbbackend.service.ServiceStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RoomTypeServiceImpl implements RoomTypeService {
//    @Autowired
//    private RoomTypeRepository roomTypeRepository;
//
//    @Autowired
//    private HouseRepository houseRepository;
//
//    @Override
//    public ServiceResult createRoomType(RoomType roomType) {
//        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setData(roomTypeRepository.save(roomType));
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult findAll() {
//        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setData(roomTypeRepository.findAll());
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult findById(Long id) {
//        ServiceResult serviceResult = new ServiceResult();
//        RoomType roomType = roomTypeRepository.findById(id).orElse(null);
//        if (roomType == null) {
//            serviceResult.setMessage("RoomType Not Found");
//        }
//        serviceResult.setData(roomType);
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult deleteRoomType(Long id) {
//        ServiceResult serviceResult = new ServiceResult();
//        RoomType roomType = roomTypeRepository.findById(id).orElse(null);
//        if (roomType == null) {
//            serviceResult.setStatus(ServiceStatus.FAILED);
//            serviceResult.setMessage("RoomType Not Found");
//        } else {
//            roomTypeRepository.delete(roomType);
//        }
//        return serviceResult;
//    }
//
//    @Override
//    public ServiceResult updateRoomType(RoomType roomType) {
//        ServiceResult serviceResult = new ServiceResult();
//        if (roomTypeRepository.findById(roomType.getId()).isPresent()){
//            serviceResult.setMessage("RoomType not found");
//        } else{
//            serviceResult.setData(roomTypeRepository.save(roomType));
//        }
//        return serviceResult;
//    }
//}
