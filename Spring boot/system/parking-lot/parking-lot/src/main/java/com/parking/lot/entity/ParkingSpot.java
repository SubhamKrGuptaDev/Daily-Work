package com.parking.lot.entity;

import com.parking.lot.entity.enums.ParkingSpotStatus;
import com.parking.lot.entity.enums.SpotType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private SpotType spotType;
    @Enumerated(EnumType.ORDINAL)
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;
    private Integer spotNumber;
    private Integer floorNumber;
}
