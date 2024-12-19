package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingSpot;

public class DisplayService {

    public void addVehicleOutput(ParkingSpot spot) {
        System.out.println("Parking SpotType : "+spot.getSpotType().toString());
        System.out.println("Floor Number : "+spot.getFloorNumber());
        System.out.println("Spot Number : "+spot.getSpotNumber());
        System.out.println("Vehicle number : "+spot.getVehicle().getNumber());
    }

}
