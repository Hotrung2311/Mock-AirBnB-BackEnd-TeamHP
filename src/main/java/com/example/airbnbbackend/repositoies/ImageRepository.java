package com.example.airbnbbackend.repositoies;

import com.example.airbnbbackend.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    Images findByUrl(String url);
}
