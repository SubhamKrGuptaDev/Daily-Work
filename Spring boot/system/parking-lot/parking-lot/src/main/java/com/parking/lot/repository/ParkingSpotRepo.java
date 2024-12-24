package com.parking.lot.repository;

import com.parking.lot.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Integer> {
    Optional<ParkingSpot> findBySpotNumber(Integer spotNumber);
}
