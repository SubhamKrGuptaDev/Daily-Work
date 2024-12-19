package parking_lot.parking.com.model;

import java.util.List;

public class ParkingFloor extends BaseModel {

	private List<ParkingSpot> spots;
	private Integer floorNumber;
	
	public List<ParkingSpot> getSpots() {
		return spots;
	}
	public void setSpots(List<ParkingSpot> spots) {
		this.spots = spots;
	}
	public Integer getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	
}
