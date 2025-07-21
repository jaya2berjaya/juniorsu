package com.juniorsu.springbootjuniorsu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int quantity;

    private boolean available;

    @PrePersist
    @PreUpdate
    public void checkAvailability() {
        this.available = this.quantity > 0;
    }
}