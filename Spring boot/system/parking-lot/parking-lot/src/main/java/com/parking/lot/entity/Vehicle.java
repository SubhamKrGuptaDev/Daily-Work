package com.parking.lot.entity;

import com.parking.lot.entity.enums.VehicleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseModel {
    private String number;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne(mappedBy = "vehicle")
    private ParkingSpot spot;
}
