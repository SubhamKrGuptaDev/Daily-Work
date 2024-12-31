package com.parking.lot.dao.spot;

import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.ParkingSpotRepository;
import org.springframework.stereotype.Repository;

/**
 * Parking Spot Repository
 */
@Repository
public class ParkingSpotDaoImpl implements ParkingSpotDao<ParkingSpot, ParkingSpot> {

    private final ParkingSpotRepository repository;

    public ParkingSpotDaoImpl(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    /**
     * get parking spot object using pk id
     *
     * @param id
     * @return
     */
    @Override
    public ParkingSpot getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new GlobalException("Id not found"));
    }

    /**
     * Get Spot using parking spot number
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
     * create new parking spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot save(ParkingSpot spot) {
        try {
            return repository.save(spot);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * update existing spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot update(ParkingSpot spot) {
        try {
            ParkingSpot existingSpot = getById(spot.getId());
            return save(existingSpot);
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * Implementation pending
     *
     * @param email
     * @return
     */
    @Override
    public Integer findByVehicleNullOrderById(String email) {
//        return repository.getAvailableSpotId(email);
        return null;
    }

    /**
     * find parking spot using vehicle id
     *
     * @param id
     * @return
     */
    @Override
    public ParkingSpot findByVehicleId(Integer id) {
        return repository.findByVehicleId(id)
                .orElseThrow(() -> new GlobalException("Vehicle not present in this floor"));
    }

    /**
     * Set parking spot object new Spot - Existing Spot
     *
     * @param existingSpot
     * @param newSpot
     */
    private void setParkingSpot(ParkingSpot existingSpot, ParkingSpot newSpot) {
        try {
            existingSpot.setSpotType(newSpot.getSpotType());
            existingSpot.setSpotNumber(newSpot.getSpotNumber());
            existingSpot.setParkingSpotStatus(newSpot.getParkingSpotStatus());
            existingSpot.setVehicle(newSpot.getVehicle());
            existingSpot.setFloorNumber(newSpot.getFloorNumber());
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

}
