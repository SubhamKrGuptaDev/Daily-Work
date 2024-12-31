package com.parking.lot.exception;

/**
 * Global exception for all the custom exception
 */
public class BusinessException extends RuntimeException {

    /**
     * Message param with param constructor
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

}
