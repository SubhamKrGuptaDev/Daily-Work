package com.parking.lot.service.spot;


import com.parking.lot.dao.spot.ParkingSpotRepository;
import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.enums.ParkingSpotStatus;
import com.parking.lot.entity.enums.SpotType;
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
     *
     *
     * @param spotType
     * @param spotNumber
     * @param floor
     * @return
     */
    @Override
    public ParkingSpot getParkingSpotObject(SpotType spotType, Integer[] spotNumber, ParkingFloor floor) {
        ParkingSpot spot = new ParkingSpot();

        spot.setSpotType(spotType);
        spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        spot.setFloor(floor);
        spot.setSpotNumber(spotNumber[0]++);
        spot.setFloorNumber(floor.getFloorNumber());

        return spot;
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
