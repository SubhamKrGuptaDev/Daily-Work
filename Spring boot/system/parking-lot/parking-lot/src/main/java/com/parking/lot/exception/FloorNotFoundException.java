package com.parking.lot.exception;

import static com.parking.lot.constants.ExceptionMessageConstants.FLOOR_NOT_FOUND_EXCEPTION_MESSAGE;

public class FloorNotFoundException extends RuntimeException {

    public FloorNotFoundException() {
        super(FLOOR_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    public FloorNotFoundException(String message) {
        super(message);
    }

}
