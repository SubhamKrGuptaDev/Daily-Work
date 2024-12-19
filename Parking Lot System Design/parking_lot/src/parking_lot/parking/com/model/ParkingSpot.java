package parking_lot.parking.com.model;

import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.SpotType;

/**
 *
 */
public class ParkingSpot extends BaseModel {

	private SpotType spotType;
	private ParkingSpotStatus parkingSpotStatus;
	private Vehicle vehicle;
	private Integer spotNumber;
	private Integer floorNumber;

	public Integer getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(Integer spotNumber) {
		this.spotNumber = spotNumber;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public SpotType getSpotType() {
		return spotType;
	}
	
	public void setSpotType(SpotType spotType) {
		this.spotType = spotType;
	}
	
	public ParkingSpotStatus getParkingSpotStatus() {
		return parkingSpotStatus;
	}
	
	public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
		this.parkingSpotStatus = parkingSpotStatus;
	}

}
