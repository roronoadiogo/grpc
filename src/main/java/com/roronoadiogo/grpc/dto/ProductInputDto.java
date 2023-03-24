package com.roronoadiogo.grpc.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public record ProductInputDto(
        @NotBlank(message = "Product name cannot be blank")
        @Size(min = 8, message = "Specify a name more precise for your product") String name,
        @DecimalMin(value = "0.1", message = "You need to have a minimum value")
        @NotBlank(message = "Need specify a value") Double price,
        @Min(value = 1, message = "Need specify a min stock")
        @NotBlank(message = "Stock cannot be empty")
        Integer quantityInStock) {

    public ProductInputDto {
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantityInStock);
    }
}

