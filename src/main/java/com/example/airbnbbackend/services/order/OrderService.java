package com.example.airbnbbackend.services.order;

import com.example.airbnbbackend.models.Orders;
import com.example.airbnbbackend.repositoies.OrderRepository;
import com.example.airbnbbackend.services.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IGeneralService<Orders> {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders findByName(String username) {
        return null;
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void remove(Orders orders) {
        orderRepository.delete(orders);
    }
}
