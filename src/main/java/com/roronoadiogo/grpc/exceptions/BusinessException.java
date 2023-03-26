package com.roronoadiogo.grpc.exceptions;

import io.grpc.Status;

public class BusinessException extends BusinessBaseException {

    private final Status errorCode;
    private final String cause;
    public BusinessException(String cause, Status code) {
        super(cause);
        if (cause == null) {
            throw new IllegalArgumentException("cause cannot be null");
        }
        if (code == null) {
            throw new IllegalArgumentException("errorCode cannot be null");
        }
        this.cause = cause;
        this.errorCode = code;
    }

    @Override
    public Status getStatusCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        String ERROR_MESSAGE_FORMAT = "Status code: %s, Cause: %s";
        return String.format(ERROR_MESSAGE_FORMAT, this.cause, this.errorCode);
    }

}
