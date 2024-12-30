package com.parking.lot.dto.models;


/**
 * Parking Lot Request Object collect data from client
 */
public class ParkingLotRequest {

    private String name;
    private String email;
    private String password;
    private String address;

    private Integer totalFloors;
    private Integer totalBikeSpots;
    private Integer totalCarSpots;
    private Integer totalTruckSpots;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Integer getTotalBikeSpots() {
        return totalBikeSpots;
    }

    public void setTotalBikeSpots(Integer totalBikeSpots) {
        this.totalBikeSpots = totalBikeSpots;
    }

    public Integer getTotalCarSpots() {
        return totalCarSpots;
    }

    public void setTotalCarSpots(Integer totalCarSpots) {
        this.totalCarSpots = totalCarSpots;
    }

    public Integer getTotalTruckSpots() {
        return totalTruckSpots;
    }

    public void setTotalTruckSpots(Integer totalTruckSpots) {
        this.totalTruckSpots = totalTruckSpots;
    }
}
