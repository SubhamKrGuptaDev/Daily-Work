package com.parking.lot.service.vehicle;

import com.parking.lot.dao.lot.ParkingLotRepository;
import com.parking.lot.dao.spot.ParkingSpotRepository;
import com.parking.lot.dao.vehicle.VehicleRepository;
import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.Vehicle;
import com.parking.lot.entity.enums.ParkingSpotStatus;
import com.parking.lot.service.strategy.LinearParkingSpotFindingStrategy;
import com.parking.lot.service.strategy.ParkingSpotFindStrategy;
import com.parking.lot.service.strategy.ParkingSpotVehicleTypeMatchingService;
import org.springframework.stereotype.Service;

import static com.parking.lot.constants.MessageConstants.SUCCESSFULLY_REMOVE;

/**
 * Vehicle Service for handle vehicle related operation
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private final ParkingLotRepository parkingLotRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository spotRepository;

    public VehicleServiceImpl(ParkingLotRepository parkingLotRepository, VehicleRepository repository, ParkingSpotRepository spotRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = repository;
        this.spotRepository = spotRepository;
    }

    /**
     * Add Vehicle in this parking lot
     *
     * @param email
     * @param request
     * @return
     */
    @Override
    public ParkingSpot addVehicleInParkingLot(String email, VehicleRequest request) {
        Vehicle vehicleObj = null;
        if(vehicleRepository.existsByNumber(request.getVehicleNumber())) {
            vehicleObj = vehicleRepository.get(request.getVehicleNumber());
        } else {
            vehicleObj = vehicleRepository.addVehicle(request);
        }

        ParkingLot existingParking = parkingLotRepository.getByEmail(email);

        ParkingSpotFindStrategy findStrategy = new LinearParkingSpotFindingStrategy(new ParkingSpotVehicleTypeMatchingService());

        ParkingSpot availableSpot = findStrategy.getAvailableSpot(request.getType(), existingParking);
        availableSpot.setVehicle(vehicleObj);
        availableSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);

        return spotRepository.save(availableSpot);
    }

    /**
     * remove vehicle from parking spot
     *
     * @param email
     * @param request
     * @return
     */
    @Override
    public String removeVehicle(String email, VehicleRequest request) {
        Vehicle existingVehicle = vehicleRepository.get(request.getVehicleNumber());
        ParkingSpot existingSpot = spotRepository.findByVehicleId(existingVehicle.getId());
        existingSpot.setVehicle(null);
        existingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);

        spotRepository.save(existingSpot);
        return SUCCESSFULLY_REMOVE;
    }
}
