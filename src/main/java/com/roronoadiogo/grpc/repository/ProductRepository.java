package com.roronoadiogo.grpc.repository;

import com.roronoadiogo.grpc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
