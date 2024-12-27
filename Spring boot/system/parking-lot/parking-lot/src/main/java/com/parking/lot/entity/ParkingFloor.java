package com.parking.lot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ParkingFloor extends BaseModel {
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ParkingSpot> spots;
    private Integer floorNumber;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    @JsonBackReference
    private ParkingLot parkingLot;

    private Integer bikeTotalSpots;
    private Integer carTotalSpots;
    private Integer TruckTotalSpots;

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Integer getBikeTotalSpots() {
        return bikeTotalSpots;
    }

    public void setBikeTotalSpots(Integer bikeTotalSpots) {
        this.bikeTotalSpots = bikeTotalSpots;
    }

    public Integer getCarTotalSpots() {
        return carTotalSpots;
    }

    public void setCarTotalSpots(Integer carTotalSpots) {
        this.carTotalSpots = carTotalSpots;
    }

    public Integer getTruckTotalSpots() {
        return TruckTotalSpots;
    }

    public void setTruckTotalSpots(Integer truckTotalSpots) {
        TruckTotalSpots = truckTotalSpots;
    }
}
