package parking_lot.parking.com.model;

import java.util.List;

/**
 * Parking Lot Floor details
 */
public class ParkingFloor extends BaseModel {

	private List<ParkingSpot> spots;
	private Integer floorNumber;

	private Integer bikeTotalSpots;
	private Integer carTotalSpots;
	private Integer TruckTotalSpots;

	public Integer getBikeTotalSpots() {
		return bikeTotalSpots;
	}

	public void setBikeTotalSpots(Integer bikeTotalSpots) {
		this.bikeTotalSpots = bikeTotalSpots;
	}

	public Integer getCarTotalSpots() {
		return carTotalSpots;
	}

	public void setCarTotalSpots(Integer carTotalSpots) {
		this.carTotalSpots = carTotalSpots;
	}

	public Integer getTruckTotalSpots() {
		return TruckTotalSpots;
	}

	public void setTruckTotalSpots(Integer truckTotalSpots) {
		TruckTotalSpots = truckTotalSpots;
	}

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
