package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.VehicleType;

public class LinearParkingSpotFindingStrategy implements ParkingSpotFindStrategy {

	private final ParkingSpotVehicleTypeMatchingService vehicleMatchingService;
	
	public LinearParkingSpotFindingStrategy(ParkingSpotVehicleTypeMatchingService vehicleMatchingService) {
		this.vehicleMatchingService = vehicleMatchingService;
	}

	/**
	 * Get available Spot using vehicle type in parking lot
	 *
	 * @param vehicleType
	 * @param parkingLot
	 * @return
	 */
	@Override
	public ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot) {

		for(ParkingFloor floor : parkingLot.getFloors()) {
			for(ParkingSpot spot : floor.getSpots()) {
				if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
						vehicleMatchingService.matches(spot.getSpotType(), vehicleType)) {
					return spot;
				}
			}
		}
		
		throw new GlobalException("Parking Spot not available for Vehicle : " + vehicleType.toString());
	}

	/**
	 * Get vehicle Spot using vehicle Number in Parking Lot
	 *
	 * @param vehicleNumber
	 * @param parkingLot
	 * @return
	 */
	@Override
	public ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot) {
		for(ParkingFloor floor : parkingLot.getFloors()) {
			for(ParkingSpot spot : floor.getSpots()) {
				if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.UNAVAILABLE)) {
					Vehicle curVehicle = spot.getVehicle();
					if(curVehicle != null && curVehicle.getNumber().equals(vehicleNumber)) {
						return spot;
					}
				}
			}
		}
		throw new GlobalException("Vehicle Number not found");
	}

}
