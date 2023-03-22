package com.roronoadiogo.grpc.controller;

import com.roronoadiogo.grpc.ProductRequest;
import com.roronoadiogo.grpc.ProductResponse;
import com.roronoadiogo.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductController extends ProductServiceGrpc.ProductServiceImplBase {

}
