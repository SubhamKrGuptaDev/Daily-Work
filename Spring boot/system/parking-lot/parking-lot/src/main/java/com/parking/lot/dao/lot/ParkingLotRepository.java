package com.parking.lot.dao.lot;

import com.parking.lot.entity.ParkingLot;

import java.util.List;

/**
 * Parking Lot repository abstraction layer
 */
public interface ParkingLotRepository {
    ParkingLot save(ParkingLot parkingLot);
    ParkingLot getByName(String name);
    ParkingLot getByEmail(String email);
    ParkingLot update(ParkingLot parkingLot);
    Boolean isPresent(String email);

    List<ParkingLot> getAll();

}
