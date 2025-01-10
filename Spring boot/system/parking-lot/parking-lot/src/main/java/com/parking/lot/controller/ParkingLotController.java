package com.parking.lot.controller;

import com.parking.lot.dto.models.ParkingLotRequest;
import com.parking.lot.entity.ParkingLot;
import com.parking.lot.service.lot.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.parking.lot.constants.ApiConstants.PARKING_LOT_API_CHECK;
import static com.parking.lot.constants.ApiConstants.PARKING_LOT_API;

/**
 * Parking Lot Controller
 */
@RestController
@RequestMapping(PARKING_LOT_API)
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService lotService) {
        this.parkingLotService = lotService;
    }

    /**
     * find all the Parking lot
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(parkingLotService.getAll());
    }

    /**
     * create new Parking lot
     *
     * @param lotRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> save(@RequestBody ParkingLotRequest lotRequest) {
        return ResponseEntity.ok(parkingLotService.save(lotRequest));
    }

    /**
     * get existing parking lot using name
     *
     * @param name
     * @return
     */
    @GetMapping(params = "name")
    public ResponseEntity<ParkingLot> getByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(parkingLotService.getByName(name));
    }

    /**
     * update parking lot with new object
     *
     * @param lot
     * @return
     */
    @PutMapping
    public ResponseEntity<ParkingLot> update(@RequestBody ParkingLot lot) {
        return ResponseEntity.ok(parkingLotService.update(lot));
    }

    /**
     * check parking lot present or not using parking lot name
     *
     * @param name
     * @return
     */
    @GetMapping(value = PARKING_LOT_API_CHECK, params = "name")
    public ResponseEntity<Boolean> isPresent(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(parkingLotService.isPresent(name));
    }

}
