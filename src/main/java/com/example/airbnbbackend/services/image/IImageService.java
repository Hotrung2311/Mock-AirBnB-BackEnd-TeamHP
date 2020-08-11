package com.example.airbnbbackend.services.image;

import com.example.airbnbbackend.models.Images;
import com.example.airbnbbackend.services.IGeneralService;

public interface IImageService extends IGeneralService<Images> {
    Images findByUrl(String url);
}
