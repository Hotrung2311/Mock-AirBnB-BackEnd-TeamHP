package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.enumm.ServiceStatus;
import com.example.airbnbbackend.model.HouseType;
import com.example.airbnbbackend.repositories.HouseRepository;
import com.example.airbnbbackend.repositories.HouseTypeRepository;
import com.example.airbnbbackend.repositories.RoomTypeRepository;
import com.example.airbnbbackend.service.HouseTypeService;
import com.example.airbnbbackend.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseTypeServiceImpl implements HouseTypeService {
    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public ServiceResult createHouseType(HouseType houseType) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(houseTypeRepository.save(houseType));
        return serviceResult;    }

    @Override
    public ServiceResult findAll() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(houseTypeRepository.findAll());
        return serviceResult;
    }

    @Override
    public ServiceResult findById(Long id) {
        ServiceResult serviceResult = new ServiceResult();
        HouseType houseType = houseTypeRepository.findById(id).orElse(null);
        if (houseType == null) {
            serviceResult.setMessage("Category Not Found");
        }
        serviceResult.setData(houseType);
        return serviceResult;    }

    @Override
    public ServiceResult deleteHouseType(Long id) {
        ServiceResult serviceResult = new ServiceResult();
        HouseType houseType = houseTypeRepository.findById(id).orElse(null);
        if (houseType == null) {
            serviceResult.setStatus(ServiceStatus.FAILED);
            serviceResult.setMessage("Category Not Found");
        } else {
            houseTypeRepository.delete(houseType);
        }
        return serviceResult;    }

    @Override
    public ServiceResult updateHouseType(HouseType houseType) {
        ServiceResult serviceResult = new ServiceResult();
        if (! houseTypeRepository.findById(houseType.getId()).isPresent()) {
            serviceResult.setMessage("Category not found");
        } else {
            serviceResult.setData(houseTypeRepository.save(houseType));
        }
        return serviceResult;    }
}
