package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.repository.ParkingSpotRepository;

/**
 * Parking Lot Spot Service
 */
public class ParkingSpotService {

    private ParkingSpotRepository repository;

    public ParkingSpotService(ParkingFloor floor) {
        repository = new ParkingSpotRepository(floor);
    }

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
