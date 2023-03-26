package com.roronoadiogo.grpc.repository;

import com.roronoadiogo.grpc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);
    boolean existsByName(String name);
}
