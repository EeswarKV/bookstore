package com.project.application;

import org.springframework.stereotype.Service;

import com.project.endpoints.dto.OrderRequestDto;
import com.project.endpoints.dto.OrderResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final List<OrderResponseDto> orders = new ArrayList<>();

    public OrderResponseDto createOrder(OrderRequestDto request) {
        OrderResponseDto response = new OrderResponseDto();
        response.setOrderId(UUID.randomUUID().toString());
        response.setItems(request.getItems());
        response.setTotalPrice(100);

        orders.add(response);
        return response;
    }

    public List<OrderResponseDto> getOrders() {
        return orders;
    }
}
