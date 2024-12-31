package com.parking.lot.service.strategy;


import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.Vehicle;
import com.parking.lot.entity.enums.ParkingSpotStatus;
import com.parking.lot.entity.enums.VehicleType;
import com.parking.lot.exception.GlobalException;

import java.util.List;

/**
 * Linear Search parking lot strategy
 */
public class LinearParkingSpotFindingStrategy implements ParkingSpotFindStrategy {

    private final ParkingSpotVehicleTypeMatchingService vehicleMatchingService;

    public LinearParkingSpotFindingStrategy(ParkingSpotVehicleTypeMatchingService vehicleMatchingService) {
        this.vehicleMatchingService = vehicleMatchingService;
    }

    /**
     * Get available Spot using vehicle type in parking lot
     * Step 1. List of Floor check
     * Step 2. List of Spot check
     * Step 3. if spot available and match vehicle type
     * Step 4. decrease available spot in that floor and return the spot
     * If spot not present then throw exception
     *
     * @param vehicleType
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot) {

        for(ParkingFloor floor : parkingLot.getFloors()) {
            if(!vehicleMatchingService.isFloorFull(vehicleType, floor)) {
                continue;
            }

            for(ParkingSpot spot : floor.getSpots()) {
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                        vehicleMatchingService.matches(spot.getSpotType(), vehicleType)) {

                    vehicleMatchingService.decreaseSizeSpotType(floor, spot.getSpotType());
                    return spot;
                }
            }
        }

        throw new GlobalException("Parking Spot not available for Vehicle : " + vehicleType.toString());
    }

    /**
     * Get vehicle Spot using vehicle Number in Parking Lot
     * Step 1. List of floor check
     * Step 2. List of spot check
     * Step 3. spot unavailable and vehicle number is same
     * Step 4. increase storage in that floor and return the spot
     * otherwise throw the exception
     *
     * @param vehicleNumber
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot) {
        for(ParkingFloor floor : parkingLot.getFloors()) {
            for(ParkingSpot spot : floor.getSpots()) {
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.UNAVAILABLE)) {
                    Vehicle curVehicle = spot.getVehicle();
                    if(curVehicle != null && curVehicle.getNumber().equals(vehicleNumber)) {
                        vehicleMatchingService.increaseSpotInFloor(floor, curVehicle.getVehicleType());
                        return spot;
                    }
                }
            }
        }
        throw new GlobalException("Vehicle Number not found");
    }

    /**
     * get spot based on floorNumber and spotNumber from Parking Lot
     * Step 1. check floor is valid
     * Step 2. get the floor object
     * Step 3. check spot is valid
     * Step 4. return direct that spot based on the number
     *
     * @param floor
     * @param spotNumber
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingSpot getSpot(Integer floor, Integer spotNumber, ParkingLot parkingLot) {
        if(!isFloorValid(floor, parkingLot)) {
            throw new GlobalException("Floor not found");
        }
        ParkingFloor existingFloor = parkingLot.getFloors().get(floor);
        if(!isSpotValid(spotNumber, existingFloor)) {
            throw new GlobalException("Spot not found");
        }

        return existingFloor.getSpots().get(spotNumber);
    }

    /**
     * floor number checker is valid or not
     *
     * @param floor
     * @param parkingLot
     * @return
     */
    private Boolean isFloorValid(Integer floor, ParkingLot parkingLot) {
        List<ParkingFloor> floors = parkingLot.getFloors();
        return floor <= floors.size();
    }

    /**
     * Spot number checker is valid or not
     *
     * @param spot
     * @param floors
     * @return
     */
    private Boolean isSpotValid(Integer spot, ParkingFloor floors) {
        List<ParkingSpot> spots = floors.getSpots();
        return spot <= spots.size();
    }

}
