package com.example.airbnbbackend.services.detail;

import com.example.airbnbbackend.models.Details;
import com.example.airbnbbackend.repositoies.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService  implements IDetailService{

    @Autowired
    DetailRepository detailRepository;

    @Override
    public List<Details> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Optional<Details> findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public Details findByName(String username) {
        return null;
    }

    @Override
    public Details save(Details details) {
        return detailRepository.save(details);
    }

    @Override
    public void remove(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public void remove(Details details) {
        detailRepository.delete(details);
    }
}
