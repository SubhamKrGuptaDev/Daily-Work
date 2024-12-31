package com.parking.lot.dao.spot;

import com.parking.lot.entity.ParkingSpot;

/**
 * Parking Spot repository abstraction layer
 */
public interface ParkingSpotDao {

    ParkingSpot getById(Integer id);
    ParkingSpot getBySpotNumber(Integer spotNumber);
    ParkingSpot save(ParkingSpot spot);
    ParkingSpot update(ParkingSpot spot);

    Integer findByVehicleNullOrderById(String email);

    ParkingSpot findByVehicleId(Integer id);
}
