package com.roronoadiogo.grpc.util;

import com.roronoadiogo.grpc.domain.Product;
import com.roronoadiogo.grpc.dto.ProductInputDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductMapperTest {

    @Test
    @DisplayName("Testing the conversion Product Mapper to Dto")
    public void product_ToDto_onSuccess(){
        var product = new Product(1L, "Test Product", 20.00, 10);
        var dto = MapperProduct.INSTANCE.toDto(product);

        assertThat(product)
                .usingRecursiveComparison()
                .isEqualTo(dto);
    }

    @Test
    @DisplayName("Testing the conversion Product Mapper to Entity")
    public void product_ToEntityToDto_onSuccess(){
        var productInput = new ProductInputDto("Test Product", 20.00, 10);
        Product mappedProduct = MapperProduct.INSTANCE.toEntity(productInput);

        assertThat(mappedProduct.getId()).isNull();
        assertThat(mappedProduct.getName()).isEqualTo("Test Product");
        assertThat(mappedProduct.getPrice()).isEqualTo(20.0);
        assertThat(mappedProduct.getQuantityInStock()).isEqualTo(10);

    }

}
