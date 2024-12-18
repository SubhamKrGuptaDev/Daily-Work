package parking_lot.parking.com.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingLot;

public class ParkingLotRepository {

	private Map<UUID, ParkingLot> parkingLotMap;

	public ParkingLotRepository() {
		this.parkingLotMap = new HashMap<>();
	}
	
	public ParkingLot save(ParkingLot parkingLot) {
		if(parkingLotMap.containsKey(parkingLot.getId())) {
			throw new GlobalException("ParkingLot already present");
		}
		
		return parkingLotMap.put(parkingLot.getId(), parkingLot);
	}
	
	public ParkingLot get(Integer id) {
		if(parkingLotMap.containsKey(id)) {
			throw new GlobalException("ParkingLot not found | Id : " + id);
		}
		return parkingLotMap.get(id);
	}
	
	public ParkingLot update(ParkingLot parkingLot) {
		if(!parkingLotMap.containsKey(parkingLot.getId())) {
			throw new GlobalException("ParkingLot not found");
		}
		return parkingLotMap.put(parkingLot.getId(), parkingLot);
	}
	
}
