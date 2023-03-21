package com.roronoadiogo.grpc.dto;

import java.util.Objects;

public record ProductInputDto(String name, Double price, Integer quantityInStock) {
    public ProductInputDto {
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantityInStock);
    }
}

