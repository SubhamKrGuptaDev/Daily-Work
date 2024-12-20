package parking_lot.parking.com.repository;

import java.util.List;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;

/**
 * Parking Floor Repository
 */
public class ParkingFloorRepository {

	private final List<ParkingFloor> floors;
	
	public ParkingFloorRepository(List<ParkingFloor> floors) {
		this.floors = floors;
	}

	/**
	 * create new Parking Floor into parking lot
	 *
	 * @param newFloor
	 * @return
	 */
	public ParkingFloor save(ParkingFloor newFloor) {
		for(ParkingFloor floor : floors) {
			if(floor.getFloorNumber().equals(newFloor.getFloorNumber())) {
				throw new GlobalException("This Floor Already present | Floor number : " + newFloor.getFloorNumber());
			}
		}
		floors.add(newFloor);
		return newFloor;
	}

	/**
	 * get existing parking floor from parking lot
	 *
	 * @param existingFloor
	 * @return
	 */
	public ParkingFloor get(Integer existingFloor) {
		for(ParkingFloor floor : floors) {
			if(floor.getFloorNumber().equals(existingFloor)) {
				return floor;
			}
		}
		throw new GlobalException("Floor not found");
	}

	/**
	 * update parking floor
	 *
	 * @param newFloor
	 * @return
	 */
	public ParkingFloor update(ParkingFloor newFloor) {
		for(int index = 0; index < floors.size(); index++) {
			ParkingFloor curFloor = floors.get(index);
			if(curFloor.getFloorNumber().equals(newFloor.getFloorNumber())) {
				floors.set(index, newFloor);
			}
		}
		throw new GlobalException("Floor not found");
	}
	
}
