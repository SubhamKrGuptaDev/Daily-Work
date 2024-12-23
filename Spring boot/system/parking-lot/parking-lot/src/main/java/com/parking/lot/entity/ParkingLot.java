package com.parking.lot.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingLot extends BaseModel {
    private String name;
    private List<ParkingFloor> floors;
    private String address;

    private Boolean isSpotAvailable;
}
