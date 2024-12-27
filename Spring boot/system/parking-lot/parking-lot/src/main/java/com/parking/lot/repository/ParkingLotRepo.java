package com.parking.lot.repository;

import com.parking.lot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingLotRepo extends JpaRepository<ParkingLot, Integer> {
    Boolean existsByName(String name);

    Optional<ParkingLot> findByName(String name);

    Boolean existsByEmail(String email);

    Optional<ParkingLot> findByEmail(String email);
}
