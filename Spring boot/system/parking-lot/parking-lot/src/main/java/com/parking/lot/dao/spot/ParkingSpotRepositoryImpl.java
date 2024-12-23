package com.parking.lot.dao.spot;

import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.GlobalException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Parking Spot Repository
 */
@Repository
public class ParkingSpotRepositoryImpl implements ParkingSpotRepository {



    /**
     * Get Spot from floor
     *
     * @param spotNumber
     * @return
     */
    public ParkingSpot get(Integer spotNumber) {
        isValidSpot(spotNumber, null);
        return floorSpots.get(spotNumber);
    }

    /**
     * create new spot
     *
     * @param spot
     * @return
     */
    public ParkingSpot save(ParkingSpot spot) {
        floorSpots.add(spot);
        return spot;
    }

    /**
     * update spot
     *
     * @param spotNumber
     * @param spot
     * @return
     */
    public ParkingSpot update(Integer spotNumber, ParkingSpot spot) {
        isValidSpot(spotNumber, spot);
        floorSpots.set(spotNumber, spot);
        return spot;
    }

    /**
     * valid spot number checker
     */
    private void isValidSpot(Integer spotNumber, ParkingSpot spot) {
        if(floorSpots.size() <= spotNumber) {
            throw new GlobalException("Spot not available");
        }

    }


}
