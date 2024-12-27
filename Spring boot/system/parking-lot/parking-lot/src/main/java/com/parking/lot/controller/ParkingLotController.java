package com.parking.lot.controller;

import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.service.lot.ParkingLotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
     * find all the Parking lot
     *
     * @return
     */
    @GetMapping
    public List<ParkingLot> getAll() {
        return lotService.getAll();
    }

    /**
     * create new Parking lot
     *
     * @param lotRequest
     * @return
     */
    @PostMapping
    public Map<String, String> save(@RequestBody ParkingLotRequest lotRequest) {
        return lotService.save(lotRequest);
    }

    /**
     * get existing parking lot using name
     *
     * @param name
     * @return
     */
    @GetMapping(params = "name")
    public ParkingLot getByName(@RequestParam(name = "name") String name) {
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
    @GetMapping(path = "/checker", params = "name")
    public Boolean isPresent(@RequestParam(name = "name") String name) {
        return lotService.isPresent(name);
    }

}
