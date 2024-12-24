package com.parking.lot.service.lot;

import com.parking.lot.dao.lot.ParkingLotRepository;
import com.parking.lot.entity.ParkingLot;
import org.springframework.stereotype.Service;

/**
 * Parking Lot Service
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository repository;

    public ParkingLotServiceImpl(ParkingLotRepository repository) {
        this.repository = repository;
    }

    /**
     * Create new Parking Lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        return repository.save(parkingLot);
    }

    /**
     * get existing parking lot using parking lot name
     *
     * @param name
     * @return
     */
    @Override
    public ParkingLot getByName(String name) {
        return repository.getByName(name);
    }

    /**
     * update parking lot
     *
     * @param lot
     * @return
     */
    @Override
    public ParkingLot update(ParkingLot lot) {
        return repository.update(lot);
    }

    /**
     * check parking lot present or not
     *
     * @param name
     * @return
     */
    @Override
    public Boolean isPresent(String name) {
        return repository.isPresent(name);
    }

}
