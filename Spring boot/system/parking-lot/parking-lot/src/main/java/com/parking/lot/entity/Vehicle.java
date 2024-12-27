package com.parking.lot.entity;

import com.parking.lot.entity.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Vehicle extends BaseModel {
    @Column(unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne(mappedBy = "vehicle")
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
