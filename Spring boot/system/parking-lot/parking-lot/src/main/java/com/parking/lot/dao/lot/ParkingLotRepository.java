package com.parking.lot.dao.lot;

import com.parking.lot.entity.ParkingLot;

import java.util.List;

public interface ParkingLotRepository {
    ParkingLot save(ParkingLot parkingLot);
    ParkingLot getByName(String name);
    ParkingLot update(ParkingLot parkingLot);
    Boolean isPresent(String name);

    List<ParkingLot> getAll();
}
