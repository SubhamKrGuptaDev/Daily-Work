package parking_lot.parking.com.repository;

import java.util.List;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;

public class ParkingFloorRepository {

	List<ParkingFloor> floors;
	
	public ParkingFloorRepository(List<ParkingFloor> floors) {
		this.floors = floors;
	}
	
	public ParkingFloor save(ParkingFloor newFloor) {
		for(ParkingFloor floor : floors) {
			if(floor.getFloorNumber().equals(newFloor.getFloorNumber())) {
				throw new GlobalException("This Floor Already present | Floor number : " + newFloor.getFloorNumber());
			}
		}
		floors.add(newFloor);
		return newFloor;
	}
	
	public ParkingFloor get(ParkingFloor existingFloor) {
		for(ParkingFloor floor : floors) {
			if(floor.getFloorNumber().equals(existingFloor.getFloorNumber())) {
				return floor;
			}
		}
		throw new GlobalException("Floor not found");
	}
	
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