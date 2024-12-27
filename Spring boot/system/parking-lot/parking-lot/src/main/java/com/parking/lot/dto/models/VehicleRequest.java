package com.parking.lot.dto.models;


import com.parking.lot.entity.enums.VehicleType;

public class VehicleRequest {

    private String vehicleNumber;
    private VehicleType type;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
