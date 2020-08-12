package com.example.airbnbbackend.controllers;

import com.example.airbnbbackend.models.Orders;
import com.example.airbnbbackend.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrder(){
        List<Orders> ordersList = orderService.findAll();
        return new ResponseEntity<List<Orders>>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable("id") Long id){
        Optional<Orders> optionalOrders = orderService.findById(id);
        return optionalOrders.map(order ->
                new ResponseEntity<Orders>(order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Orders>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createNewDetail(Orders orders){
        return new ResponseEntity<Orders>(orderService.save(orders), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") Long id, Orders orders){
        Optional<Orders> optionalOrders = orderService.findById(id);
        return optionalOrders.map(order -> {
            orders.setId(order.getId());
            return new ResponseEntity<Orders>(orderService.save(orders), HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<Orders>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Orders> deleteOrder(@PathVariable("id") Long id) {
        Optional<Orders> optionalOrders = orderService.findById(id);
        return optionalOrders.map(orders -> {
            orderService.remove(id);
            return new ResponseEntity<Orders>(orders, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<Orders>(HttpStatus.NOT_FOUND));
    }
}
