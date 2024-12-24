package com.parking.lot.service.spot;

import com.parking.lot.entity.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot get(Integer spotNumber);
    ParkingSpot save(ParkingSpot spot);
    ParkingSpot update(ParkingSpot spot);
}
