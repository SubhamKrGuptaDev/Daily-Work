package com.parking.lot.service.floor;

import com.parking.lot.dao.floor.ParkingFloorDao;
import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingFloor;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.entity.enums.SpotType;
import com.parking.lot.service.spot.ParkingSpotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Parking floor service
 */
@Service
public class ParkingFloorServiceImpl implements ParkingFloorService {

    private final ParkingFloorDao<ParkingFloor,ParkingFloor> floorDao;
    private final ParkingSpotService spotService;

    public ParkingFloorServiceImpl(ParkingFloorDao<ParkingFloor,ParkingFloor> repository,
                                   ParkingSpotService spotService) {
        this.floorDao = repository;
        this.spotService = spotService;
    }

    /**
     * get existing parking floor
     *
     * @param floor
     * @return
     */
    @Override
    public ParkingFloor get(Integer floor) {
        return floorDao.getById(floor);
    }

    /**
     * create new floor in parking lot
     *
     * @param request
     * @param newParkingLot
     * @param floorNumber
     * @return
     */
    @Override
    public ParkingFloor createWithParkingLot(ParkingLotRequest request, ParkingLot newParkingLot, Integer floorNumber) {
        ParkingFloor newFloor = new ParkingFloor();
        newFloor.setFloorNumber(floorNumber);
        newFloor.setBikeTotalSpots(request.getTotalBikeSpots());
        newFloor.setCarTotalSpots(request.getTotalCarSpots());
        newFloor.setTruckTotalSpots(request.getTotalTruckSpots());
        newFloor.setParkingLot(newParkingLot);


        // Parking Spot for bike
        List<ParkingSpot> listSpots = new ArrayList<>();
        Integer[] spotNumber = {1};
        for(int i=0; i<newFloor.getBikeTotalSpots(); i++) {
            listSpots.add(spotService.getParkingSpotObject(SpotType.SMALL, spotNumber, newFloor));
        }

        // Parking Spot for car
        for(int i=0; i<newFloor.getCarTotalSpots(); i++) {
            listSpots.add(spotService.getParkingSpotObject(SpotType.MEDIUM, spotNumber, newFloor));
        }

        // Parking Spot for truck
        for(int i=0; i<newFloor.getTruckTotalSpots(); i++) {
            listSpots.add(spotService.getParkingSpotObject(SpotType.LARGE, spotNumber, newFloor));
        }

        newFloor.setSpots(listSpots);

        return newFloor;
    }

    /**
     * update parking lot floor
     *
     * @param floor
     * @return
     */
    @Override
    public ParkingFloor update(ParkingFloor floor) {
        return floorDao.update(floor);
    }

}
