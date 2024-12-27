package com.parking.lot.exception;

/**
 * Global exception for all the custom exception
 */
public class GlobalException extends RuntimeException {

    /**
     *
     *
     * @param message
     */
    public GlobalException(String message) {
        super(message);
    }

}
