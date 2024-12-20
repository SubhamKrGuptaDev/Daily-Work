package parking_lot.parking.com.repository;

import java.util.HashMap;
import java.util.Map;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingLot;

/**
 * Parking Lot repository
 */
public class ParkingLotRepository {

	/**
	 * using in memory storage
	 */
	private final Map<String, ParkingLot> parkingLotMap;

	public ParkingLotRepository() {
		this.parkingLotMap = new HashMap<>();
	}

	/**
	 * create new Parking lot
	 *
	 * @param parkingLot
	 * @return
	 */
	public ParkingLot save(ParkingLot parkingLot) {
		if(isPresent(parkingLot.getName())) {
			throw new GlobalException("ParkingLot already present");
		}
		
		return parkingLotMap.put(parkingLot.getName(), parkingLot);
	}

	/**
	 * get parking lot using name
	 *
	 * @param name
	 * @return
	 */
	public ParkingLot get(String name) {
		if(!isPresent(name)) {
			throw new GlobalException("ParkingLot not found | Name : " + name);
		}
		return parkingLotMap.get(name);
	}

	/**
	 * update parking lot
	 *
	 * @param parkingLot
	 * @return
	 */
	public ParkingLot update(ParkingLot parkingLot) {
		if(!isPresent(parkingLot.getName())) {
			throw new GlobalException("ParkingLot not found");
		}
		return parkingLotMap.put(parkingLot.getName(), parkingLot);
	}

	/**
	 * check parking lot already present or not
	 *
	 * @param name
	 * @return
	 */
	public Boolean isPresent(String name) {
		return parkingLotMap.containsKey(name);
	}

}
