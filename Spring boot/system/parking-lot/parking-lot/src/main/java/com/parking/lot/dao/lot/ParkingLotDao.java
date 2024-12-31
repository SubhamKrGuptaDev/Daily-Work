package com.parking.lot.dao.lot;

import com.parking.lot.dao.CrudOperation;
import com.parking.lot.entity.ParkingLot;

import java.util.List;

/**
 * Parking Lot repository abstraction layer
 */
public interface ParkingLotDao<R,T> extends CrudOperation<R,T> {
    ParkingLot getByName(String name);
    ParkingLot getByEmail(String email);
    Boolean isPresent(String email);

    List<ParkingLot> getAll();

}
