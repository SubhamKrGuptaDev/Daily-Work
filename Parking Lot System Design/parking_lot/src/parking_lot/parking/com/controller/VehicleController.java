package parking_lot.parking.com.controller;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.service.strategy.ParkingSpotFindStrategy;

public class VehicleController {

    private final ParkingLot parkingLot;
    private final ParkingSpotFindStrategy spotFindStrategy;

    public VehicleController(ParkingLot parkingLot, ParkingSpotFindStrategy spotFindStrategy) {
        this.parkingLot = parkingLot;
        this.spotFindStrategy = spotFindStrategy;
    }

    public ParkingSpot addVehicleFromParkingLot(Vehicle vehicle) {
        /**
         * Step1: find spot
         * Step2: add vehicle
         */
        ParkingSpot availableSpot = spotFindStrategy.getAvailableSpot(vehicle.getVehicleType(), parkingLot);
        availableSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);
        availableSpot.setVehicle(vehicle);

        return availableSpot;
    }

    public ParkingSpot removeVehicleFromParkingLot(Vehicle vehicle) {
        /**
         *
         */


        return null;
    }

}
