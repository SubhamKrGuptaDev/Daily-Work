package com.parking.lot.repository;

import com.parking.lot.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Integer> {
    /**
     * find parking spot using spot number
     *
     * @param spotNumber
     * @return
     */
    Optional<ParkingSpot> findBySpotNumber(Integer spotNumber);

    /**
     * find Parking spot using vehicle id
     *
     * @param id
     * @return
     */
    Optional<ParkingSpot> findByVehicleId(Integer id);
}
