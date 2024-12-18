package parking_lot.parking.com.model;

import parking_lot.parking.com.model.enums.VehicleType;

public class Vehicle extends BaseModel {

	private String number;
	private VehicleType vehicleType;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
