package com.parking.lot.dao.vehicle;

import com.parking.lot.dto.models.VehicleRequest;
import com.parking.lot.entity.Vehicle;
import com.parking.lot.exception.BusinessException;
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
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
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
                .orElseThrow(() -> new BusinessException("Vehicle Number not found"));
    }

    /**
     * create new vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle save(Vehicle vehicle) {
        try {
            return repo.save(vehicle);
        } catch (Exception ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    /**
     * update existing vehicle
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        try {
            Vehicle existingObj = getById(vehicle.getId());
            setVehicle(existingObj, vehicle);

            return save(existingObj);
        } catch(Exception ex) {
            throw new BusinessException(ex.getMessage());
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
            throw new BusinessException(ex.getMessage());
        }
    }

    /**
     * Add Vehicle (Create vehicle)
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
            throw new BusinessException(ex.getMessage());
        }
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
        try {
            return repo.existsByNumber(vehicleNumber);
        } catch (Exception ex) {
            throw new BusinessException(ex.getMessage());
        }
    }
}
