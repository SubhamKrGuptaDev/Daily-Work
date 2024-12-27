package com.parking.lot.repository;

import com.parking.lot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> findByNumber(String vehicleNumber);

    Boolean existsByNumber(String vehicleNumber);
}
