package com.roronoadiogo.grpc.exceptions.handler;

import com.roronoadiogo.grpc.exceptions.BusinessException;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ExceptionHandler {

    @GrpcExceptionHandler(BusinessException.class)
    public StatusRuntimeException handleBusinessException(BusinessException e){
        return e.getStatusCode()
                .withDescription(e.getErrorMessage())
                .asRuntimeException();
    }

}
