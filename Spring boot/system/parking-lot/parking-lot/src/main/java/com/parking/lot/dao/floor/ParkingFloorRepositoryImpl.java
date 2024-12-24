package com.parking.lot.dao.floor;

import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.ParkingFloorRepo;
import org.springframework.stereotype.Repository;

/**
 * Parking Floor Repository
 */
@Repository
public class ParkingFloorRepositoryImpl implements ParkingFloorRepository {

    private final ParkingFloorRepo repo;

    public ParkingFloorRepositoryImpl(ParkingFloorRepo repo) {
        this.repo = repo;
    }

    /**
     * create new Parking Floor into parking lot
     *
     * @param newFloor
     * @return
     */
    @Override
    public ParkingFloor save(ParkingFloor newFloor) {
        return repo.save(newFloor);
    }

    /**
     * get existing parking floor from parking lot
     *
     * @param existingFloor
     * @return
     */
    @Override
    public ParkingFloor get(Integer existingFloor) {
        return repo.findById(existingFloor)
                .orElseThrow(() -> new GlobalException("ParkingFloor id not found"));
    }

    /**
     * update parking floor
     *
     * @param newFloor
     * @return
     */
    @Override
    public ParkingFloor update(ParkingFloor newFloor) {
        ParkingFloor existingFloor = get(newFloor.getId());
        setParkingFloorObject(existingFloor, newFloor);
        return save(existingFloor);
    }

    private void setParkingFloorObject(ParkingFloor oldFloor, ParkingFloor newFloor) {
        oldFloor.setFloorNumber(newFloor.getFloorNumber());
        oldFloor.setBikeTotalSpots(newFloor.getBikeTotalSpots());
        oldFloor.setCarTotalSpots(newFloor.getCarTotalSpots());
        oldFloor.setTruckTotalSpots(newFloor.getTruckTotalSpots());
    }

}
