package com.parking.lot.repository;

import com.parking.lot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    /**
     * check parking lot by name
     *
     * @param name
     * @return
     */
    Boolean existsByName(String name);

    /**
     * find Parking lot using name
     *
     * @param name
     * @return
     */
    Optional<ParkingLot> findByName(String name);

    /**
     * Check Parking lot by email
     *
     * @param email
     * @return
     */
    Boolean existsByEmail(String email);

    /**
     * Find Parking lot by email
     *
     * @param email
     * @return
     */
    Optional<ParkingLot> findByEmail(String email);
}
