package com.project.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "books")
@Data
@Builder
@AllArgsConstructor
public class BookEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    private String title;
    private String author;
    private double price;

    @Column(name = "in_stock")
    private boolean inStock;

    protected BookEntity() {}

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isInStock() { return inStock; }
    public void setInStock(boolean inStock) { this.inStock = inStock; }
}
