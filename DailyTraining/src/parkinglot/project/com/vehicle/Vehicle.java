package parkinglot.project.com.vehicle;

import java.time.LocalDateTime;

import parkinglot.project.com.enums.VehicleType;

/**
 * 
 */
public abstract class Vehicle {

	private String VehicleNumber;
	private VehicleType vehicleType;
	private LocalDateTime entryTime;
	
	public abstract Vehicle getVehicleDetails(String vehicleNumber);
	
}
