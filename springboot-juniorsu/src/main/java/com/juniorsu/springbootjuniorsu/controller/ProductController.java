package com.juniorsu.springbootjuniorsu.controller;

import com.juniorsu.springbootjuniorsu.model.Product;
import com.juniorsu.springbootjuniorsu.dto.*;
import com.juniorsu.springbootjuniorsu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @PutMapping("/quantity")
    public ResponseEntity<Product> updateQuantity(@RequestBody UpdateQuantityRequest request) {
        return ResponseEntity.ok(productService.updateQuantity(request));
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<ProductAvailabilityResponse> checkAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(productService.checkAvailability(id));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderProductResponse> orderProduct(@RequestBody OrderProductRequest request) {
        return ResponseEntity.ok(productService.orderProduct(request));
    }
}