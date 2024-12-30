package com.parking.lot.service.spot;

import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.enums.SpotType;

/**
 * Parking Spot service abstraction layer
 */
public interface ParkingSpotService {
    ParkingSpot get(Integer spotNumber);
    ParkingSpot save(ParkingSpot spot);
    ParkingSpot update(ParkingSpot spot);

    ParkingSpot getParkingSpotObject(SpotType spotType, Integer[] spotNumber, ParkingFloor floor);
}
