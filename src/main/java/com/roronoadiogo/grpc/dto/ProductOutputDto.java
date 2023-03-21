package com.roronoadiogo.grpc.dto;

import java.util.Objects;

public record ProductOutputDto(Long id, String name, Double price, Integer quantityInStock) {
    public ProductOutputDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantityInStock);
    }
}

