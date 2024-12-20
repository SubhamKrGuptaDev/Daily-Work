package parking_lot.parking.com.controller;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.service.ParkingLotService;

/**
 * Parking Lot Controller
 */
public class ParkingLotController {
	
	private ParkingLotService lotService;
	
	public ParkingLotController() {
		lotService = new ParkingLotService();
	}

	/**
	 * create new Parking lot
	 *
	 * @param lot
	 * @return
	 */
	public ParkingLot save(ParkingLot lot) {
		return lotService.save(lot);
	}

	/**
	 * get existing parking lot using name
	 *
	 * @param name
	 * @return
	 */
	public ParkingLot get(String name) {
		return lotService.get(name);
	}

	/**
	 * update parking lot
	 *
	 * @param lot
	 * @return
	 */
	public ParkingLot update(ParkingLot lot) {
		return lotService.update(lot);
	}

	/**
	 * check parking lot present or not using parking lot name
	 *
	 * @param name
	 * @return
	 */
	public Boolean isPresent(String name) {
		return lotService.isPresent(name);
	}

}
