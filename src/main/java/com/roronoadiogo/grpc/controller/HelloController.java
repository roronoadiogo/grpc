package com.roronoadiogo.grpc.controller;

import com.roronoadiogo.grpc.HelloRequest;
import com.roronoadiogo.grpc.HelloResponse;
import com.roronoadiogo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloController extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        var response = HelloResponse.newBuilder().setMessage(request.getMessage()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
