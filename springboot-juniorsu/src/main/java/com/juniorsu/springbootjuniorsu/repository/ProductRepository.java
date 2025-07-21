package com.juniorsu.springbootjuniorsu.repository;



import com.juniorsu.springbootjuniorsu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}