package parking_lot.parking.com.service;

import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.repository.ParkingFloorRepository;

/**
 * Parking floor service
 */
public class ParkingFloorService {
	
	private ParkingFloorRepository repository;
	private ParkingLot parkingLot;
	
	public ParkingFloorService(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
		repository = new ParkingFloorRepository(this.parkingLot.getFloors());
	}

	/**
	 * get existing parking floor
	 *
	 * @param floor
	 * @return
	 */
	public ParkingFloor get(Integer floor) {
		return repository.get(floor);
	}

	/**
	 * create new floor in parking lot
	 *
	 * @param floor
	 * @return
	 */
	public ParkingFloor save(ParkingFloor floor) {
		return repository.save(floor);
	}

	/**
	 * update parking lot floor
	 *
	 * @param floor
	 * @return
	 */
	public ParkingFloor update(ParkingFloor floor) {
		return repository.update(floor);
	}
	
}
