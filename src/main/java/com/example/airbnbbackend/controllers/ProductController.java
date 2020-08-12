package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.models.Products;
import com.example.airbnbbackend.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping
    public ResponseEntity<List<Products>> getAllProduct(){
        List<Products> productsList = productService.findAll();
        return new ResponseEntity<List<Products>>(productsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable("id") Long id){
        Optional<Products> optionalProducts = productService.findById(id);
        return optionalProducts.map(product ->
                new ResponseEntity<Products>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Products>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createNewProduct(Products products){
        return new ResponseEntity<Products>(productService.save(products), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Products> updateProduct(@PathVariable("id") Long id, Products products){
        Optional<Products> optionalProducts = productService.findById(id);
        return optionalProducts.map(product -> {
            products.setId(product.getId());
            return new ResponseEntity<Products>(productService.save(products), HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<Products>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Products> deleteProduct(@PathVariable("id") Long id) {
        Optional<Products> optionalProducts = productService.findById(id);
        return optionalProducts.map(products -> {
            productService.remove(id);
            return new ResponseEntity<Products>(products, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<Products>(HttpStatus.NOT_FOUND));
    }
}
