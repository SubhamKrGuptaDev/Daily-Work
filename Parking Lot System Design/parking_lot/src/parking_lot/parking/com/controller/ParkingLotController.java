package parking_lot.parking.com.controller;

import java.util.UUID;

import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.service.ParkingLotService;

public class ParkingLotController {
	
	private ParkingLotService lotService;
	
	public ParkingLotController() {
		lotService = new ParkingLotService();
	}
	
	public ParkingLot save(ParkingLot lot) {
		return lotService.save(lot);
	}
	
	public ParkingLot get(UUID id) {
		return lotService.get(id);
	}
	
	public ParkingLot update(ParkingLot lot) {
		return lotService.update(lot);
	}
	
}
