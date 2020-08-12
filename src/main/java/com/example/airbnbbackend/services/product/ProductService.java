package com.example.airbnbbackend.services.product;

import com.example.airbnbbackend.models.Products;
import com.example.airbnbbackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Products findByName(String username) {
        return productRepository.findByName(username);
    }

    @Override
    public Products save(Products products) {
        return productRepository.save(products);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void remove(Products products) {
        productRepository.delete(products);
    }
}
