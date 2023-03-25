package com.roronoadiogo.grpc.controller;

import com.roronoadiogo.grpc.ProductRequest;
import com.roronoadiogo.grpc.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@DirtiesContext
public class ProductResourceIntegrationTest {

    @GrpcClient("inProcess")
    private ProductServiceGrpc.ProductServiceBlockingStub serviceBlockingStub;

    @Test
    @DisplayName("when valid data is provide the product is created")
    public void create_product_onSuccess(){

       var productRequest = ProductRequest.newBuilder()
                .setName("product awesome")
                .setPrice(10.00)
                .setQuantityInStock(1)
               .build();

        var productResponse = serviceBlockingStub.create(productRequest);

        Assertions.assertThat(productRequest)
                .usingRecursiveComparison()
                .comparingOnlyFields("name","price","quantity_in_stock")
                .isEqualTo(productResponse);

    }

}
