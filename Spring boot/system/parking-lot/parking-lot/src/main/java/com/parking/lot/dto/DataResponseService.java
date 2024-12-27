package com.parking.lot.dto;

import com.parking.lot.dto.models.VehicleResponse;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.GlobalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataResponseService {


    public VehicleResponse addVehicleResponse(ParkingSpot parkingSpot) {
        VehicleResponse response = new VehicleResponse();

        if(parkingSpot.getVehicle() == null) {
            throw new GlobalException("Vehicle is null");
        }

        response.setType(parkingSpot.getVehicle().getVehicleType());
        response.setFloorNumber(parkingSpot.getFloorNumber());
        response.setSpotNumber(parkingSpot.getSpotNumber());
        response.setVehicleNumber(parkingSpot.getVehicle().getNumber());

        return response;
    }

//    public List<ParkingLot> convertListOfParkingLot(List<ParkingLot> parkingLots) {
//
//    }

}
