package com.parking.lot.dao.lot;

import com.parking.lot.entity.ParkingLot;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.ParkingLotRepo;
import org.springframework.stereotype.Repository;

/**
 * Parking Lot repository
 */
@Repository
public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    private final ParkingLotRepo repository;

    public ParkingLotRepositoryImpl(ParkingLotRepo repository) {
        this.repository = repository;
    }

    /**
     * create new Parking lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        return repository.save(parkingLot);
    }

    /**
     * get parking lot using name
     *
     * @param name
     * @return
     */
    @Override
    public ParkingLot getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new GlobalException("ParkingLot not find by name"));
    }

    /**
     * update parking lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot update(ParkingLot parkingLot) {
        ParkingLot existingObject = getByName(parkingLot.getName());
        return null;
    }

    /**
     * check parking lot already present or not
     *
     * @param name
     * @return
     */
    @Override
    public Boolean isPresent(String name) {
        return repository.existsByName(name);
    }

}
