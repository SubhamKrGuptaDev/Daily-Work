package parking_lot.parking.com.service;

import java.util.UUID;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.repository.ParkingLotRepository;

public class ParkingLotService {

	private ParkingLotRepository lotRepository;
	
	public ParkingLotService() {
		lotRepository = new ParkingLotRepository();
	}
	
	public ParkingLot save(ParkingLot parkingLot) {
		return lotRepository.save(parkingLot);
	}
	
	public ParkingLot get(String name) {
		return lotRepository.get(name);
	}
	
	public ParkingLot update(ParkingLot lot) {
		return lotRepository.update(lot);
	}

	public Boolean isPresent(String name) {
		return lotRepository.isPresent(name);
	}

}
