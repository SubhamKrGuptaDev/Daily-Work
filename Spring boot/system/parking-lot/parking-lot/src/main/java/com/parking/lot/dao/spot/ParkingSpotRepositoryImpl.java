package com.parking.lot.dao.spot;

import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.ParkingSpotRepo;
import org.springframework.stereotype.Repository;

/**
 * Parking Spot Repository
 */
@Repository
public class ParkingSpotRepositoryImpl implements ParkingSpotRepository {

    private final ParkingSpotRepo repository;

    public ParkingSpotRepositoryImpl(ParkingSpotRepo repository) {
        this.repository = repository;
    }

    @Override
    public ParkingSpot getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new GlobalException("Id not found"));
    }

    /**
     * Get Spot from floor
     *
     * @param spotNumber
     * @return
     */
    @Override
    public ParkingSpot getBySpotNumber(Integer spotNumber) {
        return repository.findBySpotNumber(spotNumber)
                .orElseThrow(() -> new GlobalException("Spot not found Exception"));
    }

    /**
     * create new spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    /**
     * update spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot update(ParkingSpot spot) {
        ParkingSpot existingSpot = getById(spot.getId());
        return save(existingSpot);
    }

    private void setParkingSpot(ParkingSpot existingSpot, ParkingSpot newSpot) {
        existingSpot.setSpotType(newSpot.getSpotType());
        existingSpot.setSpotNumber(newSpot.getSpotNumber());
        existingSpot.setParkingSpotStatus(newSpot.getParkingSpotStatus());
        existingSpot.setVehicle(newSpot.getVehicle());
        existingSpot.setFloorNumber(newSpot.getFloorNumber());
    }

}
