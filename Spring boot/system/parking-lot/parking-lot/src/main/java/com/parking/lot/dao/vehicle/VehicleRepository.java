package com.parking.lot.dao.vehicle;

import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.Vehicle;

public interface VehicleRepository {

    Vehicle get(Integer id);
    Vehicle get(String vehicleNumber);
    Vehicle save(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    Vehicle addVehicle(VehicleRequest request);
    String removeVehicle(String email, VehicleRequest request);
    Boolean existsByNumber(String vehicleNumber);
}
