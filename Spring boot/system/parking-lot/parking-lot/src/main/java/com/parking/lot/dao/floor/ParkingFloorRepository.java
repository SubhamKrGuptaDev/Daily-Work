package com.parking.lot.dao.floor;

import com.parking.lot.entity.ParkingFloor;

public interface ParkingFloorRepository {
    ParkingFloor save(ParkingFloor newFloor);
    ParkingFloor get(Integer existingFloor);
    ParkingFloor update(ParkingFloor newFloor);
}
