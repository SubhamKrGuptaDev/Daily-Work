package com.parking.lot.dao.lot;

import com.parking.lot.entity.ParkingLot;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.ParkingLotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Parking Lot repository
 */
@Repository
public class ParkingLotDaoImpl implements ParkingLotDao {

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
         try {
             return repository.findAll();
         } catch (Exception ex) {
             throw new GlobalException(ex.getMessage());
         }
    }

    /**
     * create new Parking lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        try {
            return repository.save(parkingLot);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
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

    @Override
    public ParkingLot getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new GlobalException("Parking lot not found by email"));
    }

    /**
     * update parking lot
     *
     * @param parkingLot
     * @return
     */
    @Override
    public ParkingLot update(ParkingLot parkingLot) {
//        ParkingLot existingObject = getByName(parkingLot.getName());
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
        try {
            return repository.existsByEmail(email);
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

}
