package com.parking.lot.service.vehicle;

import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.ParkingSpot;

public interface VehicleService {

    ParkingSpot addVehicleInParkingLot(String email, VehicleRequest request);
    String removeVehicle(String email, VehicleRequest request);

}
