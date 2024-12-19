package parking_lot.parking.com.model;

import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.SpotType;

public class ParkingSpot extends BaseModel {

	private SpotType spotType;
	private ParkingSpotStatus parkingSpotStatus;
	
	private Vehicle vehicle;

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
