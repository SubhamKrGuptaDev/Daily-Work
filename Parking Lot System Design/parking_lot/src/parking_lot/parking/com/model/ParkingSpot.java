package parking_lot.parking.com.model;

import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.SpotType;

public class ParkingSpot extends BaseModel {
	
	private Integer spotNumber;
	private SpotType spotType;
	private ParkingSpotStatus parkingSpotStatus;
	
	private Vehicle vehicle;
	
	public Integer getSpotNumber() {
		return spotNumber;
	}
	
	public void setSpotNumber(Integer spotNumber) {
		this.spotNumber = spotNumber;
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