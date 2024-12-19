package parking_lot.parking.com;

import parking_lot.parking.com.controller.ParkingLotController;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.SpotType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotOperator {

    private final ParkingLotController parkingLotController;

    public ParkingLotOperator(ParkingLotController parkingLotController) {
        this.parkingLotController = parkingLotController;
    }

    public void createParkingLot(Scanner sc) {
        /**
         * User input for Parking Lot Object
         */
        System.out.println("Enter ParkingLot Name : ");
        String lotName = sc.nextLine();
        System.out.println("Enter Number of Floors : ");
        int numFloor = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ParkingLot Address : ");
        String address = sc.nextLine();

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(lotName);
        parkingLot.setAddress(address);

        /**
         * User Input for Floor spots
         */
        List<ParkingFloor> floors = new ArrayList<>();
        for(int floor=0; floor<numFloor; floor++) {
            ParkingFloor floorObj = new ParkingFloor();
            floorObj.setFloorNumber(floor+1);

            System.out.println("Enter Floor B"+(floor+1) + " Number of Spots for BIKE : ");
            int bikeSpots = sc.nextInt();
            System.out.println("Enter Floor B"+(floor+1) + " Number of Spots for CAR : ");
            int carSpots = sc.nextInt();
            System.out.println("Enter Floor B"+(floor+1) + " Number of Spots for TRUCK : ");
            int truckSpots = sc.nextInt();

            // Bike Spots
            Integer[] index = {1};
            List<ParkingSpot> spots = createSpots(bikeSpots, SpotType.SMALL, index, floor+1);
            floorObj.setBikeTotalSpots(bikeSpots);

            // Car Spots
            spots.addAll(createSpots(carSpots, SpotType.MEDIUM, index, floor+1));
            floorObj.setCarTotalSpots(carSpots);

            // Truck Spots
            spots.addAll(createSpots(truckSpots, SpotType.LARGE, index, floor+1));
            floorObj.setTruckTotalSpots(truckSpots);

            floorObj.setSpots(spots);

            floors.add(floorObj);
        }
        sc.nextLine();

        parkingLot.setFloors(floors);
        parkingLotController.save(parkingLot);
    }

    private List<ParkingSpot> createSpots(Integer spotSize, SpotType spotType, Integer[] i, Integer floor) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        for(int index=0; index<spotSize; index++) {
            ParkingSpot spot = new ParkingSpot();

            spot.setFloorNumber(floor);
            spot.setSpotNumber(i[0]++);
            spot.setSpotType(spotType);
            spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);

            parkingSpots.add(spot);
        }

        return parkingSpots;
    }

}
