package com.parking.lot.service.floor;


import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingLot;

public interface ParkingFloorService {
    ParkingFloor get(Integer floor);
    ParkingFloor createWithParkingLot(ParkingLotRequest request, ParkingLot newParkingLot, Integer floorNumber);
    ParkingFloor update(ParkingFloor floor);
}
