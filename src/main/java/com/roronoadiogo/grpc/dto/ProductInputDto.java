package com.roronoadiogo.grpc.dto;


import javax.validation.constraints.*;
import java.util.Objects;

public record ProductInputDto(
        @NotBlank(message = "Product name cannot be blank")
        @Size(min = 8, message = "Specify a name more precise for your product") String name,
        @DecimalMin(value = "0.01", message = "You need to have a minimum value")
        @NotNull(message = "Need specify a value") Double price,
        @Min(value = 1, message = "Need specify a min stock")
        @NotNull(message = "Stock cannot be empty")
        Integer quantityInStock) {

    public ProductInputDto {
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(quantityInStock);
    }
}

