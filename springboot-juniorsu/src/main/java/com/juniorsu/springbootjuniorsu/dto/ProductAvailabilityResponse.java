package com.juniorsu.springbootjuniorsu.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAvailabilityResponse {
    private Long productId;
    private boolean available;
    private int quantity;
}