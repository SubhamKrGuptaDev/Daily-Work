package parking_lot.parking.com.service.strategy;

import parking_lot.parking.com.exception.GlobalException;
import parking_lot.parking.com.model.ParkingFloor;
import parking_lot.parking.com.model.ParkingLot;
import parking_lot.parking.com.model.ParkingSpot;
import parking_lot.parking.com.model.Vehicle;
import parking_lot.parking.com.model.enums.ParkingSpotStatus;
import parking_lot.parking.com.model.enums.SpotType;
import parking_lot.parking.com.model.enums.VehicleType;

import java.util.List;

public class LinearParkingSpotFindingStrategy implements ParkingSpotFindStrategy {

	private final ParkingSpotVehicleTypeMatchingService vehicleMatchingService;
	
	public LinearParkingSpotFindingStrategy(ParkingSpotVehicleTypeMatchingService vehicleMatchingService) {
		this.vehicleMatchingService = vehicleMatchingService;
	}

	/**
	 * Get available Spot using vehicle type in parking lot
	 *
	 * @param vehicleType
	 * @param parkingLot
	 * @return
	 */
	@Override
	public ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot) {

		for(ParkingFloor floor : parkingLot.getFloors()) {
			if(!isFloorFull(vehicleType, floor)) {
				continue;
			}

			for(ParkingSpot spot : floor.getSpots()) {
				if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
						vehicleMatchingService.matches(spot.getSpotType(), vehicleType)) {

					decreaseSizeSpotType(floor, spot.getSpotType());
					return spot;
				}
			}
		}
		
		throw new GlobalException("Parking Spot not available for Vehicle : " + vehicleType.toString());
	}

	private Boolean isFloorFull(VehicleType vehicleType, ParkingFloor floor) {

		return switch (vehicleType) {
			case BIKE -> floor.getBikeTotalSpots() > 0;
			case CAR -> floor.getCarTotalSpots() > 0;
			case TRUCK -> floor.getTruckTotalSpots() > 0;
		};
	}

	private void decreaseSizeSpotType(ParkingFloor floor, SpotType spotStatus) {
		switch (spotStatus) {
			case SMALL -> floor.setBikeTotalSpots(floor.getBikeTotalSpots() - 1);
			case MEDIUM -> floor.setCarTotalSpots(floor.getCarTotalSpots() - 1);
			case LARGE -> floor.setTruckTotalSpots(floor.getTruckTotalSpots() - 1);
		}
	}

	/**
	 * Get vehicle Spot using vehicle Number in Parking Lot
	 *
	 * @param vehicleNumber
	 * @param parkingLot
	 * @return
	 */
	@Override
	public ParkingSpot getSpot(String vehicleNumber, ParkingLot parkingLot) {
		for(ParkingFloor floor : parkingLot.getFloors()) {
			for(ParkingSpot spot : floor.getSpots()) {
				if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.UNAVAILABLE)) {
					Vehicle curVehicle = spot.getVehicle();
					if(curVehicle != null && curVehicle.getNumber().equals(vehicleNumber)) {
						return spot;
					}
				}
			}
		}
		throw new GlobalException("Vehicle Number not found");
	}

	@Override
	public ParkingSpot getSpot(Integer floor, Integer spotNumber, ParkingLot parkingLot) {
		if(!isFloorValid(floor, parkingLot)) {
			throw new GlobalException("Floor not found");
		}
		ParkingFloor existingFloor = parkingLot.getFloors().get(floor);
		if(!isSpotValid(spotNumber, existingFloor)) {
			throw new GlobalException("Spot not found");
		}

		return existingFloor.getSpots().get(spotNumber);
	}

	private Boolean isFloorValid(Integer floor, ParkingLot parkingLot) {
		List<ParkingFloor> floors = parkingLot.getFloors();
		return floor <= floors.size();
	}

	private Boolean isSpotValid(Integer spot, ParkingFloor floors) {
		List<ParkingSpot> spots = floors.getSpots();
		return spot <= spots.size();
	}

}
