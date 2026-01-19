package com.project.endpoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BooksResponseDTO {
    private UUID id;
    private String title;
    private String author;
    private double price;
    private boolean inStock;
}
