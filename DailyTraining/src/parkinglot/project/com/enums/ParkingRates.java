package parkinglot.project.com.enums;

public enum ParkingRates {

	BIKE_FEES (10),
	CAR_FEES (20),
	TRUCK_FEES (40);
	
	public final Integer rate;
	
	private ParkingRates(Integer rate) {
		this.rate = rate;
	}
	
	public Integer getRate() {
		return rate;
	}
	
}
