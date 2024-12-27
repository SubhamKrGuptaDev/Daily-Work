package com.parking.lot.service.lot;

import com.parking.lot.dao.lot.ParkingLotRepository;
import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.service.floor.ParkingFloorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parking Lot Service
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository repository;
    private final ParkingFloorService floorService;

    public ParkingLotServiceImpl(ParkingLotRepository repository, ParkingFloorService floorService) {
        this.repository = repository;
        this.floorService = floorService;
    }

    /**
     * find all the Parking lot
     *
     * @return
     */
    @Override
    public List<ParkingLot> getAll() {
        return repository.getAll();
    }

    /**
     * Create new Parking Lot
     *
     * @param lotRequest
     * @return
     */
    @Override
    public Map<String, String> save(ParkingLotRequest lotRequest) {
        return createParkingLotObject(lotRequest);
    }

    private Map<String, String> createParkingLotObject(ParkingLotRequest request) {
        try {
            ParkingLot newParkingLot = new ParkingLot();

            // ParkingLot
            newParkingLot.setName(request.getName());
            newParkingLot.setEmail(request.getEmail());
            newParkingLot.setPassword(request.getPassword());
            newParkingLot.setAddress(request.getAddress());
            newParkingLot.setSpotAvailable(false);

            List<ParkingFloor> floorList = new ArrayList<>();
            // Parking Floor
            for (int i = 0; i < request.getTotalFloors(); i++) {
                floorList.add(floorService.createWithParkingLot(request, newParkingLot, i + 1));
            }

            // Save Parking Lot
            newParkingLot.setFloors(floorList);

            repository.save(newParkingLot);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("message","Successfully created ParkingLot");
        return messageMap;
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
