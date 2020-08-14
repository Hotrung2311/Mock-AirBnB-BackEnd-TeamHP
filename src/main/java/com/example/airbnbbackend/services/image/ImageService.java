package com.example.airbnbbackend.services.image;

import com.example.airbnbbackend.models.Images;
import com.example.airbnbbackend.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements IImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<Images> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Images> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Images findByName(String username) {
        return null;
    }

    @Override
    public Images save(Images images) {
        return imageRepository.save(images);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public void remove(Images images) {
        imageRepository.delete(images);
    }

    @Override
    public Images findByUrl(String url) {
        return imageRepository.findByUrl(url);
    }
}
