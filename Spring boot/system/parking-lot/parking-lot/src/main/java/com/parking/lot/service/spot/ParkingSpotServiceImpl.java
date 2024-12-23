package com.parking.lot.service.spot;


import com.parking.lot.entity.ParkingSpot;
import org.springframework.stereotype.Service;

/**
 * Parking Lot Spot Service
 */
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {



    /**
     * Get Spot based on spotNumber
     *
     * @param spotNumber
     * @return
     */
    public ParkingSpot get(Integer spotNumber) {
        return repository.get(spotNumber);
    }

    /**
     * Create new spot
     *
     * @param spot
     * @return
     */
    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    /**
     * Update spot
     *
     * @param spotNumber
     * @param spot
     * @return
     */
    public ParkingSpot update(Integer spotNumber, ParkingSpot spot) {
        return repository.update(spotNumber, spot);
    }

}
