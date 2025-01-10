package com.parking.lot.controller;

import com.parking.lot.dto.DataResponseService;
import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.dto.models.VehicleResponse;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.service.vehicle.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.parking.lot.constants.ApiConstants.*;

/**
 * Vehicle manage controller
 */
@RestController
@RequestMapping(VEHICLE_PARENT_API)
public class VehicleController {

    private final VehicleService vehicleService;
    private final DataResponseService responseService;

    public VehicleController(VehicleService vehicleService, DataResponseService responseService) {
        this.vehicleService = vehicleService;
        this.responseService = responseService;
    }

    /**
     * Add Vehicle in parking lot
     *
     * @param email
     * @param request
     * @return
     */
    @PostMapping(value = VEHICLE_PARENT_API_ADD, params = "email")
    public ResponseEntity<VehicleResponse> addVehicle(@RequestParam("email") String email, @RequestBody VehicleRequest request) {
        ParkingSpot parkingSpot = vehicleService.addVehicleInParkingLot(email, request);
        return ResponseEntity.ok(responseService.addVehicleResponse(parkingSpot));
    }

    /**
     * Remove vehicle from parking lot
     *
     * @param email
     * @param request
     * @return
     */
    @PostMapping(value = VEHICLE_PARENT_API_REMOVE, params = "email")
    public ResponseEntity<String> removeVehicle(@RequestParam("email") String email, @RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.removeVehicle(email, request));
    }

}