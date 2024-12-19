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
	
	public ParkingLot get(String name) {
		return lotService.get(name);
	}
	
	public ParkingLot update(ParkingLot lot) {
		return lotService.update(lot);
	}

	public Boolean isPresent(String name) {
		return lotService.isPresent(name);
	}

}
