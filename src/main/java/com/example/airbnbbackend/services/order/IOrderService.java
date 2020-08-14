package com.example.airbnbbackend.services.order;

import com.example.airbnbbackend.models.Orders;

public interface IOrderService extends org.springframework.data.jpa.repository.JpaRepository<Orders, Long> {
}
