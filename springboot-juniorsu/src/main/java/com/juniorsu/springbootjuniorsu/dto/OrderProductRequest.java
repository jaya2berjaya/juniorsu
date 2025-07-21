package com.juniorsu.springbootjuniorsu.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProductRequest {
    private Long productId;
    private int orderQuantity;
}
