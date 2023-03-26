package com.roronoadiogo.grpc.exceptions;

import io.grpc.Status;

public class ProductNotFoundException extends BusinessBaseException {
    private static final String ERROR_MESSAGE_FORMAT = "Product with ID %s not found";
    private final Long id;

    public ProductNotFoundException(Long id) {
        super(String.format(ERROR_MESSAGE_FORMAT, id));
        this.id = id;
    }

    @Override
    public Status getStatusCode() {
        return Status.NOT_FOUND;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, this.id);
    }

}
