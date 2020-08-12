package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.models.Images;
import com.example.airbnbbackend.services.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<Images>> getAllImage(){
        List<Images> imagesList = imageService.findAll();
        return new ResponseEntity<List<Images>>(imagesList, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Images> getImage(@PathVariable("id") Long id) {
        Optional<Images> imagesOptional = imageService.findById(id);
        return imagesOptional.map(images ->
            new ResponseEntity<>(images, HttpStatus.OK)
        ).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Images> createNewImage(@RequestBody Images images){
        Images _images = imageService.save(images);
        return new ResponseEntity<Images>(_images, HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Images> updateImage(@PathVariable("id") Long id, Images images){
        Optional<Images> imagesOptional = imageService.findById(id);
        return imagesOptional.map(images1 -> {
            images.setId(images1.getId());
            imageService.save(images);
            return new ResponseEntity<Images>(images, HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<Images>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Images> deleteImage(@PathVariable("id") Long id) {
        Optional<Images> imagesOptional = imageService.findById(id);
        return imagesOptional.map(images -> {
            imageService.remove(id);
            return new ResponseEntity<Images>(images, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<Images>(HttpStatus.OK));
    }



}
