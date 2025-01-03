package com.parking.lot.service.lot;

import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingLot;

import java.util.List;
import java.util.Map;

/**
 * Parking Lot service abstraction layer
 */
public interface ParkingLotService {
    Map<String, String> save(ParkingLotRequest lotRequest);
    ParkingLot getByName(String name);
    ParkingLot update(ParkingLot lot);
    Boolean isPresent(String name);

    List<ParkingLot> getAll();

}
