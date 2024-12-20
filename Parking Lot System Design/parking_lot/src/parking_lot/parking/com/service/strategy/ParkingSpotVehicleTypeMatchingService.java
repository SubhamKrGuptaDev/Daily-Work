package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.enums.SpotType;
import parking_lot.parking.com.model.enums.VehicleType;

/**
 * Parking Spot Vehicle Type Matching Service
 */
public class ParkingSpotVehicleTypeMatchingService {

	/**
	 *
	 *
	 * @param spotType
	 * @param vehicleType
	 * @return
	 */
	public Boolean matches(SpotType spotType, VehicleType vehicleType) {
		
		return switch (spotType) {
			case SMALL -> vehicleType.equals(VehicleType.BIKE);
			case MEDIUM -> vehicleType.equals(VehicleType.CAR);
			case LARGE -> vehicleType.equals(VehicleType.TRUCK);
		};
	}

	/**
	 * floor checker is spot available or not
	 *
	 * @param vehicleType
	 * @param floor
	 * @return
	 */
	public Boolean isFloorFull(VehicleType vehicleType, ParkingFloor floor) {

		return switch (vehicleType) {
			case BIKE -> floor.getBikeTotalSpots() > 0;
			case CAR -> floor.getCarTotalSpots() > 0;
			case TRUCK -> floor.getTruckTotalSpots() > 0;
		};
	}

	/**
	 * after remove vehicle spot available
	 *
	 * @param floor
	 * @param spotStatus
	 */
	public void decreaseSizeSpotType(ParkingFloor floor, SpotType spotStatus) {
		switch (spotStatus) {
			case SMALL -> floor.setBikeTotalSpots(floor.getBikeTotalSpots() - 1);
			case MEDIUM -> floor.setCarTotalSpots(floor.getCarTotalSpots() - 1);
			case LARGE -> floor.setTruckTotalSpots(floor.getTruckTotalSpots() - 1);
		}
	}

	/**
	 * Increase Spot in floor based
	 *
	 * @param floor
	 * @param vehicleType
	 */
	public void increaseSpotInFloor(ParkingFloor floor, VehicleType vehicleType) {
		switch (vehicleType) {
			case CAR -> floor.setCarTotalSpots(floor.getCarTotalSpots() + 1);
			case BIKE -> floor.setBikeTotalSpots(floor.getBikeTotalSpots() + 1);
			case TRUCK -> floor.setTruckTotalSpots(floor.getTruckTotalSpots() + 1);
		}
	}

}
