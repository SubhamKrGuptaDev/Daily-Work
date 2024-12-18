package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.model.enums.SpotType;
import parking_lot.parking.com.model.enums.VehicleType;

public class ParkingSpotVehicleTypeMatchingService {

	public Boolean matches(SpotType spotType, VehicleType vehicleType) {
		
		return switch (spotType) {
			case SMALL -> vehicleType.equals(VehicleType.BIKE);
			case MEDIUM -> vehicleType.equals(VehicleType.CAR);
			case LARGE -> vehicleType.equals(VehicleType.CAR);
		};
	}
	
}
