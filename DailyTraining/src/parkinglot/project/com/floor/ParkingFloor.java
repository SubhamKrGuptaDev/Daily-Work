package parkinglot.project.com.floor;

import java.util.List;

import parkinglot.project.com.enums.ParkingFloorStatus;
import parkinglot.project.com.spot.ParkingSpot;

/**
 * Parking Floor 
 */
public class ParkingFloor {

	private List<ParkingSpot> parkingSpots;
	private Integer floorNumber;
	private ParkingFloorStatus floorStatus;
	private Integer totalSpot;
	private Integer availableSpot;
	
	/**
	 * 
	 * 
	 * @return
	 */
	public Boolean isSpotAvailable() {
		return true;
	}
	
	/**
	 * 
	 * 
	 * @param parkingSpot
	 */
	public void addVehicle(ParkingSpot parkingSpot) {
		
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public ParkingSpot removeVehicle() {
		return null;
	}
	
}
