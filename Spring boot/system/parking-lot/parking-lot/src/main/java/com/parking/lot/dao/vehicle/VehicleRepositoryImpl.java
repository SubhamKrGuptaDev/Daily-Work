package com.parking.lot.dao.vehicle;

import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.Vehicle;
import com.parking.lot.exception.GlobalException;
import com.parking.lot.repository.VehicleRepo;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleRepo repo;

    public VehicleRepositoryImpl(VehicleRepo repo) {
        this.repo = repo;
    }

    /**
     * Get Vehicle by vehicle id
     *
     * @param id
     * @return
     */
    @Override
    public Vehicle get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new GlobalException("Vehicle not found"));
    }

    /**
     * Get vehicle by vehicle number
     *
     * @param vehicleNumber
     * @return
     */
    @Override
    public Vehicle get(String vehicleNumber) {
        return repo.findByNumber(vehicleNumber)
                .orElseThrow(() -> new GlobalException("Vehicle Number not found"));
    }

    /**
     * create vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle save(Vehicle vehicle) {
        try {
            return repo.save(vehicle);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * update vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        try {
            Vehicle existingObj = get(vehicle.getId());
            setVehicle(existingObj, vehicle);

            return save(existingObj);
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * set vehicle newVehicle -> existingVehicle
     *
     * @param existingVehicle
     * @param newVehicle
     */
    private void setVehicle(Vehicle existingVehicle, Vehicle newVehicle) {
        try {
            existingVehicle.setNumber(newVehicle.getNumber());
            existingVehicle.setVehicleType(newVehicle.getVehicleType());
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * Add Vehicle
     *
     * @param request
     * @return
     */
    @Override
    public Vehicle addVehicle(VehicleRequest request) {
        try {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setNumber(request.getVehicleNumber());
            newVehicle.setVehicleType(request.getType());
            return save(newVehicle);
        } catch(Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }

    /**
     * Remove Vehicle from parking lot
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
     * Vehicle present or not
     *
     * @param vehicleNumber
     * @return
     */
    @Override
    public Boolean existsByNumber(String vehicleNumber) {
        try {
            return repo.existsByNumber(vehicleNumber);
        } catch (Exception ex) {
            throw new GlobalException(ex.getMessage());
        }
    }
}
