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

    public ParkingSpot addVehicleInParkingLot(Vehicle vehicle) {
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
         * Step1: Find vehicle by number
         * Step2: set as null
         * Step3: set SpotType to Available
         */
        ParkingSpot findSpot = spotFindStrategy.getSpot(vehicle.getNumber(), parkingLot);
        findSpot.setVehicle(null);
        findSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);

        return findSpot;
    }

}
