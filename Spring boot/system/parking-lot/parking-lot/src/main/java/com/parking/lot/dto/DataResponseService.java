package com.parking.lot.dto;

import com.parking.lot.dto.models.VehicleResponse;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.GlobalException;
import org.springframework.stereotype.Service;


/**
 * Data Response Service
 */
@Service
public class DataResponseService {

    /**
     * Vehicle Response ParkingSpot and vehicle details data transfer object
     *
     * @param parkingSpot
     * @return
     */
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
