package parkinglot.project.com.spot;

import parkinglot.project.com.enums.ParkingSpotStatus;
import parkinglot.project.com.enums.VehicleType;
import parkinglot.project.com.vehicle.Vehicle;

/**
 * 
 */
public abstract class ParkingSpot {

	private Integer spotNumber;
	private Vehicle vehicle;
	private ParkingSpotStatus status;
	private VehicleType parkingType;
	
	public abstract Boolean isSpaceHave(VehicleType type);
	public abstract ParkingSpot getSpot(Vehicle vehicle);
	
}
