package com.roronoadiogo.grpc.exceptions;

import io.grpc.Status;

public abstract class BusinessBaseException extends RuntimeException{

    public BusinessBaseException(String cause) {
        super(cause);
    }
    public BusinessBaseException(String cause, Throwable throwable) {
        super(cause);
    }

    public abstract Status getStatusCode();

    public abstract String getErrorMessage();

}
