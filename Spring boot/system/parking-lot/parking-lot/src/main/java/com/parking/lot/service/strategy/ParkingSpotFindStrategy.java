package com.parking.lot.service.strategy;

import com.parking.lot.entity.ParkingLot;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.enums.VehicleType;

/**
 * Strategy Design Pattern [Need to change object based on requirement]
 */
public interface ParkingSpotFindStrategy {

    /**
     * Get Available Spot from parking lot
     *
     * @param vehicleType
     * @param parkingLot
     * @return
     */
    ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot);

    /**
     * Get Spot based on vehicleNumber or floorNumber, spotNumber in Parking Lot
     *
     * @param vehicleNumber
     * @param parkingLot
     * @return
     */
    ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot);
    ParkingSpot getSpot(Integer floor, Integer spotNumber, ParkingLot parkingLot);
}
