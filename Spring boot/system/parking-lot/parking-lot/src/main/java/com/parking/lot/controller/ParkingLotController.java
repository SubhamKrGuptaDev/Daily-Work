package com.parking.lot.controller;


import com.parking.lot.entity.ParkingLot;
import com.parking.lot.service.lot.ParkingLotService;
import org.springframework.web.bind.annotation.*;

/**
 * Parking Lot Controller
 */
@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {

    private final ParkingLotService lotService;

    public ParkingLotController(ParkingLotService lotService) {
        this.lotService = lotService;
    }

    /**
     * create new Parking lot
     *
     * @param lot
     * @return
     */
    @PostMapping
    public ParkingLot save(@RequestBody ParkingLot lot) {
        return lotService.save(lot);
    }

    /**
     * get existing parking lot using name
     *
     * @param name
     * @return
     */
    @GetMapping
    public ParkingLot getByName(@RequestParam String name) {
        return lotService.getByName(name);
    }

    /**
     * update parking lot
     *
     * @param lot
     * @return
     */
    @PutMapping
    public ParkingLot update(@RequestBody ParkingLot lot) {
        return lotService.update(lot);
    }

    /**
     * check parking lot present or not using parking lot name
     *
     * @param name
     * @return
     */
    @GetMapping(name = "/checker", params = "name")
    public Boolean isPresent(String name) {
        return lotService.isPresent(name);
    }

}
