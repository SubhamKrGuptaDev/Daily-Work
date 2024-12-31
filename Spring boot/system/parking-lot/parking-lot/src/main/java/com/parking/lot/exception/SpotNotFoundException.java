package com.parking.lot.exception;

import static com.parking.lot.constants.ExceptionMessageConstants.SPOT_NOT_FOUND_EXCEPTION_MESSAGE;

public class SpotNotFoundException extends RuntimeException {

    public SpotNotFoundException() {
        super(SPOT_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    public SpotNotFoundException(String message) {
        super(message);
    }

}
