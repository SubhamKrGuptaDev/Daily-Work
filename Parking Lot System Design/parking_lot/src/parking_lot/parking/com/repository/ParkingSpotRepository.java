package parking_lot.parking.com.repository;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingSpot;

import java.util.List;

public class ParkingSpotRepository {

    private final List<ParkingSpot> floorSpots;

    public ParkingSpotRepository(ParkingFloor floor) {
        this.floorSpots = floor.getSpots();
    }

    public ParkingSpot get(Integer spotNumber) {
        isValidSpot(spotNumber, null);
        return floorSpots.get(spotNumber);
    }

    public ParkingSpot save(ParkingSpot spot) {
        floorSpots.add(spot);
        return spot;
    }

    public ParkingSpot update(Integer spotNumber, ParkingSpot spot) {
        isValidSpot(spotNumber, spot);
        floorSpots.set(spotNumber, spot);
        return spot;
    }

    /**
     *
     */
    private void isValidSpot(Integer spotNumber, ParkingSpot spot) {
        if(floorSpots.size() <= spotNumber) {
            throw new GlobalException("Spot not available");
        }

    }


}
