package com.roronoadiogo.grpc.repository;

import com.roronoadiogo.grpc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIgnoreCase(String name);
}
