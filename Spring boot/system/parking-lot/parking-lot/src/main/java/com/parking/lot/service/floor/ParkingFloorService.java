package com.parking.lot.service.floor;


import com.parking.lot.entity.ParkingFloor;

public interface ParkingFloorService {
    ParkingFloor get(Integer floor);
    ParkingFloor save(ParkingFloor floor);
    ParkingFloor update(ParkingFloor floor);
}
