package com.parking.lot.repository;

import com.parking.lot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    /**
     * find by vehicle using vehicle number
     *
     * @param vehicleNumber
     * @return
     */
    Optional<Vehicle> findByNumber(String vehicleNumber);

    /**
     * check vehicle by vehicle number
     *
     * @param vehicleNumber
     * @return
     */
    Boolean existsByNumber(String vehicleNumber);
}
