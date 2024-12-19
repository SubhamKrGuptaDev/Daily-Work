package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.repository.ParkingSpotRepository;

public class ParkingSpotService {

    private ParkingSpotRepository repository;

    public ParkingSpotService(ParkingFloor floor) {
        repository = new ParkingSpotRepository(floor);
    }

    public ParkingSpot get(Integer spotNumber) {
        return repository.get(spotNumber);
    }

    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    public ParkingSpot update(Integer spotNumber, ParkingSpot spot) {
        return repository.update(spotNumber, spot);
    }

}
