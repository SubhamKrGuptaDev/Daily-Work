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
 * Parking Lot App
 */
public class ParkingLotApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLotController parkingLotController = new ParkingLotController();
        ParkingLotOperator createParkingLot = new ParkingLotOperator(parkingLotController);
        ParkingLotVehicleOperator vehicleOperator = new ParkingLotVehicleOperator();
        DisplayService displayService = new DisplayService();

        System.out.println("Welcome to ParkingLot :)\n");
        boolean isEntry = true;

        while(isEntry) {
            System.out.println("Enter your ParkingLot Name : ");
            String name = sc.nextLine();

            if(parkingLotController.isPresent(name)) {
                boolean inProgress = true;
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
                                ParkingSpot parkingSpot = vehicleController.addVehicleInParkingLot(newVehicle);
                                displayService.addVehicleOutput(parkingSpot);
                                break;
                            case 2:
                                System.out.println("\nEnter 1 for search by Vehicle number : ");
                                System.out.println("Enter 2 for search by floor and spot number : ");
                                int choice = sc.nextInt();
                                sc.nextLine();
                                ParkingSpot updateSpot = null;

                                switch(choice) {
                                    case 1:
                                        Vehicle vehicle = vehicleOperator.getVehicleData(sc);
                                        updateSpot = vehicleController.removeVehicleFromParkingLot(vehicle);
                                        break;
                                    case 2:
                                        System.out.println("Enter Floor number : ");
                                        int floor = sc.nextInt();
                                        System.out.println("Enter Spot number : ");
                                        int spot = sc.nextInt();
                                        updateSpot = vehicleController.removeVehicleFromParkingLot(floor, spot);
                                        break;
                                    default:
                                        throw new GlobalException("Option Not Valid");
                                }
                                displayService.removeSpot(updateSpot);
                                System.out.println();
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
                    System.out.println("\nSuccessfully You have added Your ParkingLot data into Application\n");
                }
            }
        }

    }
	
}
