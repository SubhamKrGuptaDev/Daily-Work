package com.parking.lot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parking.lot.entity.enums.VehicleType;
import jakarta.persistence.*;

@Entity
public class Vehicle extends BaseModel {
    @Column(unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne(mappedBy = "vehicle")
    @JsonBackReference
    private ParkingSpot spot;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }
}
