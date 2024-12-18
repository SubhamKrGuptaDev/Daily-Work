package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.VehicleType;

public class RandomParkingSpotFindingStrategy implements ParkingSpotFindStrategy {

	private ParkingSpotVehicleTypeMatchingService vehicleMatchingService;
	
	public RandomParkingSpotFindingStrategy(ParkingSpotVehicleTypeMatchingService vehicleMatchingService) {
		super();
		this.vehicleMatchingService = vehicleMatchingService;
	}

	// Using Counter we can direct check spot available or not
	
	@Override
	public ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot) {
		
		for(ParkingFloor floor : parkingLot.getFloors()) {
			for(ParkingSpot spot : floor.getSpots()) {
				if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && 
						vehicleMatchingService.matches(spot.getSpotType(), vehicleType )) {
					// get Spot available
					return spot;
				}
			}
		}
		
		throw new GlobalException("Parking Spot not available for Vehicle : " + vehicleType.toString());
	}
	
}
