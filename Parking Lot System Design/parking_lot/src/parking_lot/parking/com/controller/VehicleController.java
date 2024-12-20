package parking_lot.parking.com.controller;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.service.strategy.ParkingSpotFindStrategy;

/**
 * Vehicle manage controller
 */
public class VehicleController {

    private final ParkingLot parkingLot;
    private final ParkingSpotFindStrategy spotFindStrategy;

    public VehicleController(ParkingLot parkingLot, ParkingSpotFindStrategy spotFindStrategy) {
        this.parkingLot = parkingLot;
        this.spotFindStrategy = spotFindStrategy;
    }

    /**
     * add vehicle in parking lot
     *
     * @param vehicle
     * @return
     */
    public ParkingSpot addVehicleInParkingLot(Vehicle vehicle) {
        /**
         * Step1: find spot
         * Step2: add vehicle
         */
        if(!parkingLot.getIsSpotAvailable()) {
            throw new GlobalException("Parking Lot is full");
        }

        ParkingSpot availableSpot = spotFindStrategy.getAvailableSpot(vehicle.getVehicleType(), parkingLot);
        availableSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);
        availableSpot.setVehicle(vehicle);

        return availableSpot;
    }

    /**
     * remove vehicle from parking lot using vehicle number
     *
     * @param vehicle
     * @return
     */
    public ParkingSpot removeVehicleFromParkingLot(Vehicle vehicle) {
        /**
         * Step1: Find vehicle by number
         * Step2: set as null
         * Step3: set SpotType to Available
         */
        ParkingSpot findSpot = spotFindStrategy.getSpot(vehicle.getNumber(), parkingLot);
        setSpotFieldNull(findSpot);

        return findSpot;
    }

    /**
     * remove vehicle from parking lot using floor and spot number
     *
     * @param floor
     * @param spot
     * @return
     */
    public ParkingSpot removeVehicleFromParkingLot(Integer floor, Integer spot) {
        /**
         * Step1: Find vehicle by number
         * Step2: set as null
         * Step3: set SpotType to Available
         */
        ParkingSpot findSpot = spotFindStrategy.getSpot(floor, spot, parkingLot);
        setSpotFieldNull(findSpot);

        return findSpot;
    }

    /**
     * set spot field null after remove vehicle
     *
     * @param spot
     */
    private void setSpotFieldNull(ParkingSpot spot) {
        spot.setVehicle(null);
        spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
    }

}
