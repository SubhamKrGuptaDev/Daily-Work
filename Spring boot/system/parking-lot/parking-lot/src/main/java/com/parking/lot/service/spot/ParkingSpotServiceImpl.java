package com.parking.lot.service.spot;


import com.parking.lot.dao.spot.ParkingSpotRepository;
import com.parking.lot.entity.ParkingSpot;
import org.springframework.stereotype.Service;

/**
 * Parking Lot Spot Service
 */
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private final ParkingSpotRepository repository;

    public ParkingSpotServiceImpl(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    /**
     * Get Spot based on spotNumber
     *
     * @param spotNumber
     * @return
     */
    @Override
    public ParkingSpot get(Integer spotNumber) {
        return repository.getBySpotNumber(spotNumber);
    }

    /**
     * Create new spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    /**
     * Update spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot update(ParkingSpot spot) {
        return repository.update(spot);
    }

}
