package com.parking.lot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
public class ParkingLot extends BaseModel {
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<ParkingFloor> floors;
    private String address;

    private Boolean isSpotAvailable;


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

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSpotAvailable() {
        return isSpotAvailable;
    }

    public void setSpotAvailable(Boolean spotAvailable) {
        isSpotAvailable = spotAvailable;
    }
}
