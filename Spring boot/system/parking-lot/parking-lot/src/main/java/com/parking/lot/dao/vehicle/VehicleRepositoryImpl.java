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
     *
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
     *
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
     *
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    /**
     *
     *
     * @param vehicle
     * @return
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle existingObj = get(vehicle.getId());
        setVehicle(existingObj, vehicle);

        return save(existingObj);
    }

    /**
     *
     *
     * @param existingVehicle
     * @param newVehicle
     */
    private void setVehicle(Vehicle existingVehicle, Vehicle newVehicle) {
        existingVehicle.setNumber(newVehicle.getNumber());
        existingVehicle.setVehicleType(newVehicle.getVehicleType());
    }

    /**
     *
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
     *
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
     *
     *
     * @param vehicleNumber
     * @return
     */
    @Override
    public Boolean existsByNumber(String vehicleNumber) {
        return repo.existsByNumber(vehicleNumber);
    }
}
