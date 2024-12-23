package com.parking.lot.service.floor;

import com.parking.lot.dao.floor.ParkingFloorRepository;
import com.parking.lot.entity.ParkingFloor;
import org.springframework.stereotype.Service;

/**
 * Parking floor service
 */
@Service
public class ParkingFloorServiceImpl implements ParkingFloorService {

    private final ParkingFloorRepository repository;

    public ParkingFloorServiceImpl(ParkingFloorRepository repository) {
        this.repository = repository;
    }

    /**
     * get existing parking floor
     *
     * @param floor
     * @return
     */
    public ParkingFloor get(Integer floor) {
        return repository.get(floor);
    }

    /**
     * create new floor in parking lot
     *
     * @param floor
     * @return
     */
    public ParkingFloor save(ParkingFloor floor) {
        return repository.save(floor);
    }

    /**
     * update parking lot floor
     *
     * @param floor
     * @return
     */
    public ParkingFloor update(ParkingFloor floor) {
        return repository.update(floor);
    }

}
