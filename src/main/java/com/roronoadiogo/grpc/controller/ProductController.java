package com.roronoadiogo.grpc.controller;

import com.roronoadiogo.grpc.*;
import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.service.IProductService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductController extends ProductServiceGrpc.ProductServiceImplBase {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        var productInputDto = new ProductInputDto(request.getName(), request.getPrice(),
                request.getQuantityInStock());

            var output = productService.create(productInputDto);
            var productResponse = ProductResponse.newBuilder()
                    .setId(output.id())
                    .setName(output.name())
                    .setPrice(output.price())
                    .build();
            responseObserver.onNext(productResponse);
            responseObserver.onCompleted();

    }

    @Override
    public void findById(FindByIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.findById(request, responseObserver);
    }

    @Override
    public void delete(FindByIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.delete(request, responseObserver);
    }

    @Override
    public void findAll(EmptyRequest request, StreamObserver<FindAllList> responseObserver) {
        super.findAll(request, responseObserver);
    }
}
