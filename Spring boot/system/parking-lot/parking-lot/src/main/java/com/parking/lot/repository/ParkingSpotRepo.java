package com.parking.lot.repository;

import com.parking.lot.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Integer> {
}
