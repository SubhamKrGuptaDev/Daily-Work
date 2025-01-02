package com.parking.lot.exception;

import static com.parking.lot.constants.ExceptionMessageConstants.PARKING_LOT_NOT_FOUND_EXCEPTION_MESSAGE;

public class ParkingLotNotFoundException extends RuntimeException {

    public ParkingLotNotFoundException() {
        super(PARKING_LOT_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    public ParkingLotNotFoundException(String message) {
        super(message);
    }

}
