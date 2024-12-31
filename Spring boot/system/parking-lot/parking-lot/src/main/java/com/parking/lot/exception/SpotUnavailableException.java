package com.parking.lot.exception;

import static com.parking.lot.constants.ExceptionMessageConstants.SPOT_UNAVAILABLE_EXCEPTION_MESSAGE;

/**
 * Parking spot not available exception
 */
public class SpotUnavailableException extends RuntimeException {

    public SpotUnavailableException() {
        super(SPOT_UNAVAILABLE_EXCEPTION_MESSAGE);
    }

    public SpotUnavailableException(String message) {
        super(message);
    }

}
