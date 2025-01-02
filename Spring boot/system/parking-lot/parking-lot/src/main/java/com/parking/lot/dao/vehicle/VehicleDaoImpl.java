package com.parking.lot.dao.vehicle;

import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.Vehicle;
import com.parking.lot.exception.VehicleNotFoundException;
import com.parking.lot.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl implements VehicleDao<Vehicle,Vehicle> {

    private final VehicleRepository repo;

    public VehicleDaoImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    /**
     * Get Vehicle by vehicle id
     *
     * @param id
     * @return
     */
    @Override
    public Vehicle getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(VehicleNotFoundException::new);
    }

    /**
     * Get vehicle by vehicle registration number
     *
     * @param vehicleNumber
     * @return
     */
    @Override
    public Vehicle get(String vehicleNumber) {
        return repo.findByNumber(vehicleNumber)
                .orElseThrow(VehicleNotFoundException::new);
    }

    /**
     * create new vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    /**
     * update existing vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle existingObj = getById(vehicle.getId());
        setVehicle(existingObj, vehicle);
        return save(existingObj);
    }

    /**
     * set vehicle newVehicle -> existingVehicle
     *
     * @param existingVehicle
     * @param newVehicle
     */
    private void setVehicle(Vehicle existingVehicle, Vehicle newVehicle) {
        existingVehicle.setNumber(newVehicle.getNumber());
        existingVehicle.setVehicleType(newVehicle.getVehicleType());
    }

    /**
     * Add Vehicle (Create vehicle)
     *
     * @param request
     * @return
     */
    @Override
    public Vehicle addVehicle(VehicleRequest request) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setNumber(request.getVehicleNumber());
        newVehicle.setVehicleType(request.getType());
        return save(newVehicle);
    }

    /**
     * Implementation pending
     *
     * @param email
     * @param request
     * @return
     */
    @Override
    public String removeVehicle(String email, VehicleRequest request) {
        return "";
    }

    /**
     * Check vehicle existing or not
     *
     * @param vehicleNumber
     * @return
     */
    @Override
    public Boolean existsByNumber(String vehicleNumber) {
        return repo.existsByNumber(vehicleNumber);
    }
}
