package com.parking.lot.dao.floor;

import com.parking.lot.entity.ParkingFloor;

/**
 * Parking Floor repository abstraction layer
 */
public interface ParkingFloorDao {
    ParkingFloor save(ParkingFloor newFloor);
    ParkingFloor get(Integer existingFloor);
    ParkingFloor update(ParkingFloor newFloor);
}
