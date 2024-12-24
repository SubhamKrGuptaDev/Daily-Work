package com.parking.lot.service.lot;

import com.parking.lot.dto.ParkingLotRequest;
import com.parking.lot.entity.ParkingLot;

import java.util.List;
import java.util.Map;

public interface ParkingLotService {
    Map<String, String> save(ParkingLotRequest lotRequest);
    ParkingLot getByName(String name);
    ParkingLot update(ParkingLot lot);
    Boolean isPresent(String name);

    List<ParkingLot> getAll();

}
