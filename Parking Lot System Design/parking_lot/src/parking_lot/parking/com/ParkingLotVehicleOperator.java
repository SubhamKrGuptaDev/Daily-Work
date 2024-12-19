package parking_lot.parking.com;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.VehicleType;

import java.util.Scanner;

public class ParkingLotVehicleOperator {

    public Vehicle getVehicleData(Scanner sc) {
        Vehicle newVehicle = new Vehicle();

        System.out.println("Enter vehicle number  : ");
        String vehicleNumber = sc.nextLine();

        System.out.println("Enter vehicle Type (BIKE/CAR/TRUCK): ");
        String vehicleType = sc.nextLine();

        switch (vehicleNumber.toLowerCase()) {
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
