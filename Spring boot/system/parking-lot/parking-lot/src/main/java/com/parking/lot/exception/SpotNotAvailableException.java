package com.parking.lot.exception;

/**
 * Parking spot not available exception
 */
public class SpotNotAvailableException extends RuntimeException {

    public SpotNotAvailableException() {
        super("Parking Spot not available");
    }

    public SpotNotAvailableException(String message) {
        super(message);
    }

}
