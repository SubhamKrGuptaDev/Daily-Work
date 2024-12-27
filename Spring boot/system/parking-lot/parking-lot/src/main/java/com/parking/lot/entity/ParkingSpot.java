package com.parking.lot.entity;

import com.parking.lot.entity.enums.ParkingSpotStatus;
import com.parking.lot.entity.enums.SpotType;
import jakarta.persistence.*;

@Entity
public class ParkingSpot extends BaseModel {
    @Enumerated(EnumType.STRING)
    private SpotType spotType;
    @Enumerated(EnumType.STRING)
    private ParkingSpotStatus parkingSpotStatus;

    @ManyToOne
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor floor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    private Integer spotNumber;
    private Integer floorNumber;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
