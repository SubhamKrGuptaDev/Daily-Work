package parking_lot.parking.com.service;


import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.repository.ParkingLotRepository;

/**
 * Parking Lot Service
 */
public class ParkingLotService {

	private ParkingLotRepository lotRepository;

	public ParkingLotService() {
		lotRepository = new ParkingLotRepository();
	}

	/**
	 * Create new Parking Lot
	 *
	 * @param parkingLot
	 * @return
	 */
	public ParkingLot save(ParkingLot parkingLot) {
		return lotRepository.save(parkingLot);
	}

	/**
	 * get existing parking lot using parking lot name
	 *
	 * @param name
	 * @return
	 */
	public ParkingLot get(String name) {
		return lotRepository.get(name);
	}

	/**
	 * update parking lot
	 *
	 * @param lot
	 * @return
	 */
	public ParkingLot update(ParkingLot lot) {
		return lotRepository.update(lot);
	}

	/**
	 * check parking lot present or not
	 *
	 * @param name
	 * @return
	 */
	public Boolean isPresent(String name) {
		return lotRepository.isPresent(name);
	}

}
