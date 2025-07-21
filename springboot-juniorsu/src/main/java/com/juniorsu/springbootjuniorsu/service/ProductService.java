package com.juniorsu.springbootjuniorsu.service;

import com.juniorsu.springbootjuniorsu.model.Product;
import com.juniorsu.springbootjuniorsu.dto.*;
import com.juniorsu.springbootjuniorsu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(AddProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .available(request.getQuantity() > 0)
                .build();
        return productRepository.save(product);
    }

    public Product updateQuantity(UpdateQuantityRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setQuantity(request.getQuantity());
        product.setAvailable(request.getQuantity() > 0);
        return productRepository.save(product);
    }

    public ProductAvailabilityResponse checkAvailability(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductAvailabilityResponse.builder()
                .productId(product.getId())
                .available(product.isAvailable())
                .quantity(product.getQuantity())
                .build();
    }

    public OrderProductResponse orderProduct(OrderProductRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < request.getOrderQuantity()) {
            return OrderProductResponse.builder()
                    .productId(product.getId())
                    .productName(product.getName())
                    .orderedQuantity(0)
                    .totalPrice(0)
                    .success(false)
                    .message("Not enough stock")
                    .build();
        }

        product.setQuantity(product.getQuantity() - request.getOrderQuantity());
        product.setAvailable(product.getQuantity() > 0);
        productRepository.save(product);

        return OrderProductResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .orderedQuantity(request.getOrderQuantity())
                .totalPrice(request.getOrderQuantity() * product.getPrice())
                .success(true)
                .message("Order successful")
                .build();
    }
}