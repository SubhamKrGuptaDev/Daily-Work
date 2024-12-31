package com.parking.lot.service.strategy;

import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.enums.SpotType;
import com.parking.lot.entity.enums.VehicleType;
import org.springframework.stereotype.Service;

/**
 * Parking Spot Vehicle Type Matching Service
 */
@Service
public class ParkingSpotVehicleTypeMatchingService {

    /**
     * matches SpotType with Vehicle Type
     *
     * @param spotType
     * @param vehicleType
     * @return
     */
    public Boolean matches(SpotType spotType, VehicleType vehicleType) {

        return switch (spotType) {
            case SMALL -> vehicleType.equals(VehicleType.BIKE);
            case MEDIUM -> vehicleType.equals(VehicleType.CAR);
            case LARGE -> vehicleType.equals(VehicleType.TRUCK);
        };
    }

    /**
     * Vehicle type with floor vehicle type storage is present or not
     *
     * @param vehicleType
     * @param floor
     * @return
     */
    public Boolean isFloorFull(VehicleType vehicleType, ParkingFloor floor) {

        return switch (vehicleType) {
            case BIKE -> floor.getBikeTotalSpots() > 0;
            case CAR -> floor.getCarTotalSpots() > 0;
            case TRUCK -> floor.getTruckTotalSpots() > 0;
        };
    }

    /**
     * after remove vehicle spot available
     *
     * @param floor
     * @param spotStatus
     */
    public void decreaseSizeSpotType(ParkingFloor floor, SpotType spotStatus) {
        switch (spotStatus) {
            case SMALL -> floor.setBikeTotalSpots(floor.getBikeTotalSpots() - 1);
            case MEDIUM -> floor.setCarTotalSpots(floor.getCarTotalSpots() - 1);
            case LARGE -> floor.setTruckTotalSpots(floor.getTruckTotalSpots() - 1);
        }
    }

    /**
     * Increase Spot in floor based
     *
     * @param floor
     * @param vehicleType
     */
    public void increaseSpotInFloor(ParkingFloor floor, VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR -> floor.setCarTotalSpots(floor.getCarTotalSpots() + 1);
            case BIKE -> floor.setBikeTotalSpots(floor.getBikeTotalSpots() + 1);
            case TRUCK -> floor.setTruckTotalSpots(floor.getTruckTotalSpots() + 1);
        }
    }

}
