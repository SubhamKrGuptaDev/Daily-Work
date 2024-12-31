package com.parking.lot.dao.floor;

import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.exception.FloorNotFoundException;
import com.parking.lot.repository.ParkingFloorRepository;
import org.springframework.stereotype.Repository;

/**
 * Parking Floor Repository
 */
@Repository
public class ParkingFloorDaoImpl implements ParkingFloorDao<ParkingFloor, ParkingFloor> {

    private final ParkingFloorRepository repo;

    public ParkingFloorDaoImpl(ParkingFloorRepository repo) {
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
    public ParkingFloor getById(Integer existingFloor) {
        return repo.findById(existingFloor)
                .orElseThrow(FloorNotFoundException::new);
    }

    /**
     * update existing parking floor
     *
     * @param newFloor
     * @return
     */
    @Override
    public ParkingFloor update(ParkingFloor newFloor) {
        ParkingFloor existingFloor = getById(newFloor.getId());
        setParkingFloorObject(existingFloor, newFloor);
        return save(existingFloor);
    }

    /**
     * Set parking floor object new object -> old object
     *
     * @param oldFloor
     * @param newFloor
     */
    private void setParkingFloorObject(ParkingFloor oldFloor, ParkingFloor newFloor) {
        oldFloor.setFloorNumber(newFloor.getFloorNumber());
        oldFloor.setBikeTotalSpots(newFloor.getBikeTotalSpots());
        oldFloor.setCarTotalSpots(newFloor.getCarTotalSpots());
        oldFloor.setTruckTotalSpots(newFloor.getTruckTotalSpots());
    }

}
