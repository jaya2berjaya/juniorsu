package com.juniorsu.springbootjuniorsu.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProductResponse {
    private Long productId;
    private String productName;
    private int orderedQuantity;
    private double totalPrice;
    private boolean success;
    private String message;
}
