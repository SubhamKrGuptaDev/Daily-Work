package com.parking.lot.dao.lot;

import com.parking.lot.entity.ParkingLot;
import com.parking.lot.exception.ParkingLotNotFoundException;
import com.parking.lot.repository.ParkingLotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.parking.lot.constants.ExceptionMessageConstants.PARKING_LOT_NOT_FOUND_USING_EMAIL_MESSAGE;
import static com.parking.lot.constants.ExceptionMessageConstants.PARKING_LOT_NOT_FOUND_USING_NAME_MESSAGE;

/**
 * Parking Lot repository
 */
@Repository
public class ParkingLotDaoImpl implements ParkingLotDao<ParkingLot, ParkingLot> {

    private final ParkingLotRepository repository;

    public ParkingLotDaoImpl(ParkingLotRepository repository) {
        this.repository = repository;
    }

    /**
     * find all the Parking lot
     *
     * @return
     */
    @Override
    public List<ParkingLot> getAll() {
         return repository.findAll();
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

    @Override
    public ParkingLot getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(ParkingLotNotFoundException::new);
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
                .orElseThrow(() -> new ParkingLotNotFoundException(PARKING_LOT_NOT_FOUND_USING_NAME_MESSAGE));
    }

    @Override
    public ParkingLot getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ParkingLotNotFoundException(PARKING_LOT_NOT_FOUND_USING_EMAIL_MESSAGE));
    }

    /**
     * update parking lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot update(ParkingLot parkingLot) {
        return null;
    }

    /**
     * check parking lot already present or not
     *
     * @param email
     * @return
     */
    @Override
    public Boolean isPresent(String email) {
        return repository.existsByEmail(email);
    }

}
