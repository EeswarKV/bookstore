package com.project.endpoints;

import com.project.application.OrderService;
import com.project.endpoints.dto.OrderRequestDto;
import com.project.endpoints.dto.OrderResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersEndpoint {

    private final OrderService orderService;

    public OrdersEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}

