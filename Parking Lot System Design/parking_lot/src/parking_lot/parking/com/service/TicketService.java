package parking_lot.parking.com.service;

import java.time.LocalDateTime;
import java.util.UUID;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Ticket;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.repository.ParkingLotRepository;
import parking_lot.parking.com.service.strategy.ParkingSpotFindStrategy;
import parking_lot.parking.com.service.strategy.RandomParkingSpotFindingStrategy;

/**
 * 
 */
public class TicketService {

	private ParkingSpotFindStrategy spotFindStrategy;
	private ParkingLotRepository lotRepositor;
	
	public TicketService(ParkingSpotFindStrategy spotFindStrategy, ParkingLotRepository lotRepositor) {
		this.spotFindStrategy = spotFindStrategy;
		this.lotRepositor = lotRepositor;
	}
	
	/**
	 * 
	 * Step1. Find available spot 
	 * Step2. Generate ticket object
	 * Step3. Add all the details in ticket object
	 * Step4. Save add return
	 * 
	 */
	
	/**
	 * 
	 * 
	 * @param vehicle
	 * @param parkingLotId
	 * @return
	 */
	public Ticket getTicket(Vehicle vehicle, Integer parkingLotId) {
		ParkingSpot availableParkingSpot = spotFindStrategy.getAvailableSpot(vehicle.getVehicleType(), lotRepositor.get(parkingLotId));
		
		Ticket ticket = new Ticket();
		ticket.setId(UUID.randomUUID());
		ticket.setEntryTime(LocalDateTime.now());
		ticket.setParkingSpot(availableParkingSpot);
		ticket.setVehicle(vehicle);
		
		return ticket;
		// ticket repository save this object before return object
	}
	
	/**
	 * 
	 * 
	 * @param parkingLot
	 * @param parkingSpot
	 */
	public void updateParkingSpotStatus(ParkingLot parkingLot, ParkingSpot parkingSpot) {
		ParkingSpot existingSpot = null;
		
		for(ParkingFloor floor : parkingLot.getFloors()) {
			Boolean found = false;
			
			for(ParkingSpot spot : floor.getSpots()) {
				
				if(spot.getId().equals(parkingSpot.getId())) {
					
					if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) ) {
						spot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);
						existingSpot = spot;
					} else {
						spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
						existingSpot = spot;
					}
					
					found = true;
					break;
				}
			}
			
			if(found) {
				break;
			}
		}
		
		if(existingSpot == null) {
			throw new GlobalException("Spot not found for update");
		}
		
	}
	
}
