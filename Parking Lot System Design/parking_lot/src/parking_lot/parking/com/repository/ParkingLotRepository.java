package parking_lot.parking.com.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingLot;

public class ParkingLotRepository {

	private final Map<String, ParkingLot> parkingLotMap;

	public ParkingLotRepository() {
		this.parkingLotMap = new HashMap<>();
	}
	
	public ParkingLot save(ParkingLot parkingLot) {
		if(isPresent(parkingLot.getName())) {
			throw new GlobalException("ParkingLot already present");
		}
		
		return parkingLotMap.put(parkingLot.getName(), parkingLot);
	}
	
	public ParkingLot get(String name) {
		if(!isPresent(name)) {
			throw new GlobalException("ParkingLot not found | Name : " + name);
		}
		return parkingLotMap.get(name);
	}
	
	public ParkingLot update(ParkingLot parkingLot) {
		if(!isPresent(parkingLot.getName())) {
			throw new GlobalException("ParkingLot not found");
		}
		return parkingLotMap.put(parkingLot.getName(), parkingLot);
	}

	public Boolean isPresent(String name) {
		return parkingLotMap.containsKey(name);
	}

}
