package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.repository.ParkingFloorRepository;

/**
 * 
 */
public class ParkingFloorService {
	
	private ParkingFloorRepository repository;
	private ParkingLot parkingLot;
	
	public ParkingFloorService(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
		repository = new ParkingFloorRepository(this.parkingLot.getFloors());
	}

	public ParkingFloor get(Integer floor) {
		return repository.get(floor);
	}

	public ParkingFloor save(ParkingFloor floor) {
		return repository.save(floor);
	}

	public ParkingFloor update(ParkingFloor floor) {
		return repository.update(floor);
	}
	
}
