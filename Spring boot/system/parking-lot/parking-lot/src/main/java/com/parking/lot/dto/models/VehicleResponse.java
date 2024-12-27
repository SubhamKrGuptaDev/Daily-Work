package com.parking.lot.dto.models;

import com.parking.lot.entity.enums.VehicleType;

public class VehicleResponse {

    private String vehicleNumber;
    private VehicleType type;
    private Integer floorNumber;
    private Integer spotNumber;

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

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }
}
