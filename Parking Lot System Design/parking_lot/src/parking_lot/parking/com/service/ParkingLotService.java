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
	
	public ParkingLot get(UUID id) {
		return lotRepository.get(id);
	}
	
	public ParkingLot update(ParkingLot lot) {
		return lotRepository.update(lot);
	}
	
}
