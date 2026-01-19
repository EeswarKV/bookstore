package com.project.endpoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private String orderId;
    private String status;
    private String message;
    private int totalPrice;
    private List<OrderItemDto> items;
}
