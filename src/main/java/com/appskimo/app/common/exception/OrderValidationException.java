package com.appskimo.app.common.exception;

/**
 * Created by dominic on 2016-10-22.
 */
public class OrderValidationException extends RuntimeException {
    private static final long serialVersionUID = -1971031804368193638L;

    public OrderValidationException(String message) {
        super(message);
    }

}
