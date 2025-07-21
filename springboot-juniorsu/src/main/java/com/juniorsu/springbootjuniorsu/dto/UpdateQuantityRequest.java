package com.juniorsu.springbootjuniorsu.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateQuantityRequest {
    private Long productId;
    private int quantity;  // new quantity value
}
