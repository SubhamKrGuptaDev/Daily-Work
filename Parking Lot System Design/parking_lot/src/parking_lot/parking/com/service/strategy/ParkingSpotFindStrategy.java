package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.VehicleType;

/**
 * Strategy Design Pattern [Need to change object based on requirement]
 */
public interface ParkingSpotFindStrategy {

	ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot);

	ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot);
	ParkingSpot getSpot(Integer floor, Integer spotNumber, ParkingLot parkingLot);
}
