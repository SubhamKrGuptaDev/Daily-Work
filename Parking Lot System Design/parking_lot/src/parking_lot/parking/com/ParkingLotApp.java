package parking_lot.parking.com;

import parking_lot.parking.com.controller.ParkingLotController;
import parking_lot.parking.com.controller.VehicleController;
import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.service.DisplayService;
import parking_lot.parking.com.service.strategy.LinearParkingSpotFindingStrategy;
import parking_lot.parking.com.service.strategy.ParkingSpotVehicleTypeMatchingService;

import java.util.Scanner;

/**
 * 
 */
public class ParkingLotApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLotController parkingLotController = new ParkingLotController();
        ParkingLotOperator createParkingLot = new ParkingLotOperator(parkingLotController);
        ParkingLotVehicleOperator vehicleOperator = new ParkingLotVehicleOperator();
        DisplayService displayService = new DisplayService();

        System.out.println("Welcome to ParkingLot :)\n");
        Boolean isEntry = true;

        while(isEntry) {
            System.out.println("Enter your ParkingLot Name : ");
            String name = sc.nextLine();

            if(parkingLotController.isPresent(name)) {
                Boolean inProgress = true;
                ParkingLot parkingLot = parkingLotController.get(name);
                VehicleController vehicleController = new VehicleController(parkingLot,
                            new LinearParkingSpotFindingStrategy(
                                    new ParkingSpotVehicleTypeMatchingService()
                            )
                        );

                while(inProgress) {
                    try {
                        System.out.println("""
                                Press 1 for add vehicle :\s
                                Press 2 for remove vehicle :\s
                                Press 3 for EXIT\s""");
                        int userInput = sc.nextInt();
                        sc.nextLine();

                        switch (userInput) {
                            case 1:
                                Vehicle newVehicle = vehicleOperator.getVehicleData(sc);
                                ParkingSpot parkingSpot = vehicleController.addVehicleFromParkingLot(newVehicle);
                                displayService.addVehicleOutput(parkingSpot);
                                break;
                            case 2:
                                // TODO: Remove Vehicle
                                break;
                            case 3:
                                inProgress = false;
                                break;
                            default:
                                throw new GlobalException("Option Not Valid");
                        }
                    } catch (Exception ex) {
                        System.out.println("Error : " + ex.getMessage());
                    }

                }
                System.out.println("Thank You");
            } else if(name.equals("EXIT")) {
                System.out.println("\nThank You :)\n");
                isEntry = false;
            } else {
                System.out.println("Parking Lot not Present with this name : " + name);
                System.out.println("Do you want to create New Parking Lot (YES/NO) : ");
                String ans = sc.nextLine();
                if(ans.equalsIgnoreCase("YES")) {
                    createParkingLot.createParkingLot(sc);
                    System.out.println("\nSuccessfully You have added Your ParkingLot data to Application\n");
                }
            }
        }

    }
	
}
