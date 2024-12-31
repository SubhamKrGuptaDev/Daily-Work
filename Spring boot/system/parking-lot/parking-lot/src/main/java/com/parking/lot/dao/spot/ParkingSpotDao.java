package com.parking.lot.dao.spot;

import com.parking.lot.dao.CrudOperation;
import com.parking.lot.entity.ParkingSpot;

/**
 * Parking Spot repository abstraction layer
 */
public interface ParkingSpotDao<R,T> extends CrudOperation<R,T> {

    ParkingSpot getBySpotNumber(Integer spotNumber);

    Integer findByVehicleNullOrderById(String email);

    ParkingSpot findByVehicleId(Integer id);
}
