package com.parking.lot.controller;


import com.parking.lot.entity.ParkingLot;
import com.parking.lot.service.lot.ParkingLotServiceImpl;

/**
 * Parking Lot Controller
 */
public class ParkingLotController {

    private ParkingLotServiceImpl lotService;

    public ParkingLotController() {
        lotService = new ParkingLotServiceImpl();
    }

    /**
     * create new Parking lot
     *
     * @param lot
     * @return
     */
    public ParkingLot save(ParkingLot lot) {
        return lotService.save(lot);
    }

    /**
     * get existing parking lot using name
     *
     * @param name
     * @return
     */
    public ParkingLot get(String name) {
        return lotService.get(name);
    }

    /**
     * update parking lot
     *
     * @param lot
     * @return
     */
    public ParkingLot update(ParkingLot lot) {
        return lotService.update(lot);
    }

    /**
     * check parking lot present or not using parking lot name
     *
     * @param name
     * @return
     */
    public Boolean isPresent(String name) {
        return lotService.isPresent(name);
    }

}
