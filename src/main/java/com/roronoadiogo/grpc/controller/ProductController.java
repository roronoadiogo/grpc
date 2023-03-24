package com.roronoadiogo.grpc.controller;

import com.roronoadiogo.grpc.*;
import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.exceptions.BusinessException;
import com.roronoadiogo.grpc.service.IProductService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GrpcService
public class ProductController extends ProductServiceGrpc.ProductServiceImplBase {

    @Autowired
    private IProductService productService;

    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) throws BusinessException {
        super.create(request, responseObserver);

        var productInputDto = new ProductInputDto(request.getName(), request.getPrice(),
                request.getQuantityInStock());

        productService.create(productInputDto);
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
