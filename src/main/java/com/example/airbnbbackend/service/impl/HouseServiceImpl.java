package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.enumm.ServiceStatus;
import com.example.airbnbbackend.model.Account;
import com.example.airbnbbackend.model.Address;
import com.example.airbnbbackend.model.House;
import com.example.airbnbbackend.model.ImageHouse;
import com.example.airbnbbackend.repositories.*;
import com.example.airbnbbackend.service.HouseService;
import com.example.airbnbbackend.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Autowired
    private ImageHouseRepository imageHouseRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void save(House house) {
        houseRepository.save(house);
    }

    @Override
    public void delete(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public List<House> findAllHouse(Long id) {
        return houseRepository.findByAccount_Id(id);
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public Optional<House> findByAddress(Address address) {
        return houseRepository.findByAddress(address);
    }


    // bang add
    @Override
    public ServiceResult createHouse(House house, String username) {
        ServiceResult serviceResult = new ServiceResult();
        Optional<Account> optionalUser = accountRepository.findByUsername(username);
        if(!optionalUser.isPresent()) {
            serviceResult.setStatus(ServiceStatus.FAILED);
            return serviceResult;
        }
        Account account = optionalUser.get();
        house.setAccount(account);
        // get and remove picture list from apartment
        List<ImageHouse> ImagesList = house.getImageHouses();
        house.setImageHouses(null);
        // get and remove address from apartment
        Address address = house.getAddress();
        house.setAddress(null);
        // save apartment without address and picture list
        House newHouse = houseRepository.save(house);

        address.setHouse(house);
        addressRepository.save(address);

        ImagesList.forEach(imageHouse -> {
            imageHouse.setHouse(newHouse);
            imageHouse = imageHouseRepository.save(imageHouse);
        });

        serviceResult.setMessage("add new House success");
        return serviceResult;
    }

    @Override
    public ServiceResult updateHouse(Long id, House house) {
        return null;
    }

    @Override
    public ServiceResult updateHousePicture(Long id, List<ImageHouse> ImagesList, String hostname) {
        return null;
    }

    @Override
    public ServiceResult findAllHouse() {
        return null;
    }

    @Override
    public ServiceResult findHouseById(Long id) {
        return null;
    }

    @Override
    public ServiceResult searchHouse(int bedroom, int bathroom, Long province_id) {
        return null;
    }

    @Override
    public ServiceResult findAllByHost(String hostname) {
        return null;
    }
//        ServiceResult serviceResult = new ServiceResult();
//        Optional<Account> optionalHost = accountRepository.findByUsername(hostname);
//        if(!optionalHost.isPresent()){
//            serviceResult.setStatus(ServiceStatus.FAILED);
//            return serviceResult;
//        }
//        Account host = optionalHost.get();
//        List<House> houseList = houseRepository.findAllByUser(host);
//        serviceResult.setData(houseList);
//        serviceResult.setMessage("success");
//        serviceResult.setStatus(ServiceStatus.SUCCESS);
//        return serviceResult;
//    }
}
