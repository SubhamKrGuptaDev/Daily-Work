package com.parking.lot.dao.vehicle;

import com.parking.lot.dao.CrudOperation;
import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.Vehicle;

/**
 * Vehicle repository abstraction layer
 */
public interface VehicleDao<R,T> extends CrudOperation<R,T> {

    Vehicle get(String vehicleNumber);
    Vehicle addVehicle(VehicleRequest request);
    Boolean existsByNumber(String vehicleNumber);
}
