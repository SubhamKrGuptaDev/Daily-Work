package parking_lot.parking.com.controller;

import parking_lot.parking.com.service.ParkingLotService;

public class ParkingLotController {
	
	private ParkingLotService lotService;
	
	public ParkingLotController() {
		lotService = new ParkingLotService();
	}
	
}
