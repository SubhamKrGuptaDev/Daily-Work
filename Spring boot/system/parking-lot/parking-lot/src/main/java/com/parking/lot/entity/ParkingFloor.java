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
public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> spots;
    private Integer floorNumber;

    private Integer bikeTotalSpots;
    private Integer carTotalSpots;
    private Integer TruckTotalSpots;
}
