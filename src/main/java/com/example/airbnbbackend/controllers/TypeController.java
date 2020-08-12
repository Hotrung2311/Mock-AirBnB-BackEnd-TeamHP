package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.models.Products;
import com.example.airbnbbackend.models.Types;
import com.example.airbnbbackend.services.product.ProductService;
import com.example.airbnbbackend.services.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeService typeService;


    @GetMapping
    public ResponseEntity<List<Types>> getAllType(){
        List<Types> typesList = typeService.findAll();
        return new ResponseEntity<List<Types>>(typesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Types> getType(@PathVariable("id") Long id){
        Optional<Types> typesOptional = typeService.findById(id);
        return typesOptional.map(type ->
                new ResponseEntity<Types>(type, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Types>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Types> createNewType(Types types){
        return new ResponseEntity<Types>(typeService.save(types), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Types> updateType(@PathVariable("id") Long id, Types types){
        Optional<Types> optionalTypes = typeService.findById(id);
        return optionalTypes.map(type -> {
            types.setId(type.getId());
            return new ResponseEntity<Types>(typeService.save(types), HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<Types>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Types> deleteType(@PathVariable("id") Long id) {
        Optional<Types> optionalTypes = typeService.findById(id);
        return optionalTypes.map(types -> {
            typeService.remove(id);
            return new ResponseEntity<Types>(types, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<Types>(HttpStatus.NOT_FOUND));
    }
}
