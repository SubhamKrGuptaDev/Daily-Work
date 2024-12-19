package parking_lot.parking.com.model;

import java.util.List;

/**
 *
 */
public class ParkingLot extends BaseModel {

	private String name;
	private List<ParkingFloor> floors;
	private String address;

	private Boolean isSpotAvailable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsSpotAvailable() {
		return isSpotAvailable;
	}
	public void setIsSpotAvailable(Boolean isSpotAvailable) {
		this.isSpotAvailable = isSpotAvailable;
	}
	public List<ParkingFloor> getFloors() {
		return floors;
	}
	public void setFloors(List<ParkingFloor> floors) {
		this.floors = floors;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
