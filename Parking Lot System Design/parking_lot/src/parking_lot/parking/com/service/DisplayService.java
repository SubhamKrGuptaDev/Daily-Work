package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingSpot;

public class DisplayService {

    public void addVehicleOutput(ParkingSpot spot) {
        System.out.println("\nParking SpotType : "+spot.getSpotType().toString());
        System.out.println("Floor Number : "+spot.getFloorNumber());
        System.out.println("Spot Number : "+spot.getSpotNumber());
        System.out.println("Vehicle number : "+spot.getVehicle().getNumber());
        System.out.println("Vehicle Added Successfully\n");
    }

    public void removeSpot(ParkingSpot updateSpot) {
        System.out.println("\nParking SpotType : " + updateSpot.getSpotType());
        System.out.println("Floor Number : "+updateSpot.getFloorNumber());
        System.out.println("Spot Number : "+updateSpot.getSpotNumber()+"\n");
        System.out.println("Vehicle remove Successfully\n");
    }
}
