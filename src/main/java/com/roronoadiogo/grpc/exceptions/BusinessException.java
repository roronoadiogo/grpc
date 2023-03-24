package com.roronoadiogo.grpc.exceptions;
public class BusinessException extends Exception{

    public BusinessException(String cause) {
        super(cause);
    }

    public BusinessException(String cause, Throwable throwable) {
        super(cause);
    }
}
