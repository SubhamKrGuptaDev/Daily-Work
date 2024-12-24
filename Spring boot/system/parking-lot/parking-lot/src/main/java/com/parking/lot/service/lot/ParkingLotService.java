package com.parking.lot.service.lot;

import com.parking.lot.entity.ParkingLot;

public interface ParkingLotService {
    ParkingLot save(ParkingLot parkingLot);
    ParkingLot getByName(String name);
    ParkingLot update(ParkingLot lot);
    Boolean isPresent(String name);
}
