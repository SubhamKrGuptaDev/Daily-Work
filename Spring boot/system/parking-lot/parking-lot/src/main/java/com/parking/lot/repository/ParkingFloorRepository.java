package com.parking.lot.repository;

import com.parking.lot.entity.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Integer> {
}
