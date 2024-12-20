package parking_lot.parking.com;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.VehicleType;

import java.util.Scanner;
import java.util.UUID;

/**
 * Parking Lot Vehicle Operator
 */
public class ParkingLotVehicleOperator {

    /**
     * Get new vehicle object
     *
     * @param sc
     * @return
     */
    public Vehicle getVehicleData(Scanner sc) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setId(UUID.randomUUID());

        System.out.println("Enter vehicle number  : ");
        String vehicleNumber = sc.nextLine();
        newVehicle.setNumber(vehicleNumber);

        System.out.println("Enter vehicle Type (BIKE/CAR/TRUCK): ");
        String vehicleType = sc.nextLine().toLowerCase();

        switch (vehicleType) {
            case "bike":
                newVehicle.setVehicleType(VehicleType.BIKE);
                break;
            case "car":
                newVehicle.setVehicleType(VehicleType.CAR);
                break;
            case "truck":
                newVehicle.setVehicleType(VehicleType.TRUCK);
                break;
            default:
                throw new GlobalException("Wrong input Vehicle Type");
        }

        return newVehicle;
    }

}
