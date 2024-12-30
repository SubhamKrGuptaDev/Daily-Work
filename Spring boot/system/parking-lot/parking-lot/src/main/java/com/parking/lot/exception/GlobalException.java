package com.parking.lot.exception;

/**
 * Global exception for all the custom exception
 */
public class GlobalException extends RuntimeException {

    /**
     * Message param with param constructor
     *
     * @param message
     */
    public GlobalException(String message) {
        super(message);
    }

}
