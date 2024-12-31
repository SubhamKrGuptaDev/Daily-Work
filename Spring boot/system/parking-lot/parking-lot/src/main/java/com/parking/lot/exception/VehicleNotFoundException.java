package com.parking.lot.exception;

import static com.parking.lot.constants.ExceptionMessageConstants.VEHICLE_NOT_FOUND_EXCEPTION_MESSAGE;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException() {
        super(VEHICLE_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }

}
