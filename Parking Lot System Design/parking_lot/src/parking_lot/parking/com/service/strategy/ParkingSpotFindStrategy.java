package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.enums.VehicleType;

/**
 * Strategy Design Pattern [Need to change object based on requirement]
 */
public interface ParkingSpotFindStrategy {

	/**
	 * Get Available Spot from parking lot
	 *
	 * @param vehicleType
	 * @param parkingLot
	 * @return
	 */
	ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot);

	/**
	 * Get Spot based on vehicleNumber or floorNumber, spotNumber in Parking Lot
	 *
	 * @param vehicleNumber
	 * @param parkingLot
	 * @return
	 */
	ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot);
	ParkingSpot getSpot(Integer floor, Integer spotNumber, ParkingLot parkingLot);
}
