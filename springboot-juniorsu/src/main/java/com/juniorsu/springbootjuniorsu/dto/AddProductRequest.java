package com.juniorsu.springbootjuniorsu.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProductRequest {
    private String name;
    private double price;
    private int quantity;
}
