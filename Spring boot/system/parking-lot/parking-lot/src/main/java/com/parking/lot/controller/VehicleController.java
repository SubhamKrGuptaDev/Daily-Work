package com.parking.lot.controller;

import com.parking.lot.dto.DataResponseService;
import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.dto.models.VehicleResponse;
import com.parking.lot.entity.ParkingSpot;
import com.parking.lot.service.vehicle.VehicleService;
import org.springframework.web.bind.annotation.*;

/**
 * Vehicle manage controller
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private final DataResponseService responseService;

    public VehicleController(VehicleService vehicleService, DataResponseService responseService) {
        this.vehicleService = vehicleService;
        this.responseService = responseService;
    }

    @PostMapping(value = "/add", params = "email")
    public VehicleResponse addVehicle(@RequestParam("email") String email, @RequestBody VehicleRequest request) {
        ParkingSpot parkingSpot = vehicleService.addVehicleInParkingLot(email, request);
        return responseService.addVehicleResponse(parkingSpot);
    }

    @PostMapping(value = "/remove", params = "email")
    public String removeVehicle(@RequestParam("email") String email, @RequestBody VehicleRequest request) {
        return vehicleService.removeVehicle(email, request);
    }

}