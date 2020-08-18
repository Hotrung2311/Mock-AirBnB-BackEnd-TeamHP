package com.example.airbnbbackend.service;

import com.example.airbnbbackend.enumm.ServiceStatus;
import lombok.Data;

@Data
public class ServiceResult {
    private ServiceStatus status = ServiceStatus.SUCCESS;
    private String message;
    private Object data;
}
