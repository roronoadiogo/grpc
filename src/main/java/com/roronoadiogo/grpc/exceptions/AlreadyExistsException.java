package com.roronoadiogo.grpc.exceptions;

import io.grpc.Status;

public class AlreadyExistsException extends BusinessBaseException {

    private static String ERROR_MESSAGE_FORMAT = "Product %s already exists in the system.";
    private final String name;

    public AlreadyExistsException(String name) {
        super(String.format(ERROR_MESSAGE_FORMAT, name));
        this.name = name;
    }

    @Override
    public Status getStatusCode() {
        return Status.ALREADY_EXISTS;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, this.name);
    }

}
