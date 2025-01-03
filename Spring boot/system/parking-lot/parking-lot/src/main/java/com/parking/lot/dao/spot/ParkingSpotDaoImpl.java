package com.parking.lot.dao.spot;

import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.exception.BusinessException;
import com.parking.lot.exception.ParkingLotNotFoundException;
import com.parking.lot.exception.SpotNotFoundException;
import com.parking.lot.exception.VehicleNotFoundException;
import com.parking.lot.repository.ParkingSpotRepository;
import org.springframework.stereotype.Repository;

import static com.parking.lot.constants.ExceptionMessageConstants.ID_NOT_FOUND_EXCEPTION_MESSAGE;
import static com.parking.lot.constants.ExceptionMessageConstants.VEHICLE_NOT_FOUND_USING_FLOOR;

/**
 * Parking Spot Repository
 */
@Repository
public class ParkingSpotDaoImpl implements ParkingSpotDao<ParkingSpot, ParkingSpot> {

    private final ParkingSpotRepository repository;

    public ParkingSpotDaoImpl(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    /**
     * get parking spot object using pk id
     *
     * @param id
     * @return
     */
    @Override
    public ParkingSpot getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SpotNotFoundException(ID_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    /**
     * Get Spot using parking spot number
     *
     * @param spotNumber
     * @return
     */
    @Override
    public ParkingSpot getBySpotNumber(Integer spotNumber) {
        return repository.findBySpotNumber(spotNumber)
                .orElseThrow(SpotNotFoundException::new);
    }

    /**
     * create new parking spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    /**
     * update existing spot
     *
     * @param spot
     * @return
     */
    @Override
    public ParkingSpot update(ParkingSpot spot) {
        ParkingSpot existingSpot = getById(spot.getId());
        return save(existingSpot);
    }

    /**
     * find parking spot using vehicle id
     *
     * @param id
     * @return
     */
    @Override
    public ParkingSpot findByVehicleId(Integer id) {
        return repository.findByVehicleId(id)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND_USING_FLOOR));
    }

}
