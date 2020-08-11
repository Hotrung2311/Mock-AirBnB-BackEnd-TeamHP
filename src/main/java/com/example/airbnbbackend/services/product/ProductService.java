package com.example.airbnbbackend.services.product;

import com.example.airbnbbackend.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductService productService;

    @Override
    public List<Products> findAll() {
        return productService.findAll();
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productService.findById(id);
    }

    @Override
    public Products findByName(String username) {
        return productService.findByName(username);
    }

    @Override
    public Products save(Products products) {
        return productService.save(products);
    }

    @Override
    public void remove(Long id) {
        productService.remove(id);
    }

    @Override
    public void remove(Products products) {
        productService.remove(products);
    }
}
