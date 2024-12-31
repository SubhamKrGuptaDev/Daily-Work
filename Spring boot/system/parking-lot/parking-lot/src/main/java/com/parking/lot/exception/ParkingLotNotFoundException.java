package com.parking.lot.exception;

public class ParkingLotNotFoundException extends RuntimeException {

    public ParkingLotNotFoundException() {
        super("Parking Lot not found");
    }

    public ParkingLotNotFoundException(String message) {
        super(message);
    }

}
