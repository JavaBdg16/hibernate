package repository;

import entity.userdetails.Vehicle;

import javax.persistence.EntityManager;

public class VehicleRepository extends Repository<Vehicle> {
    public VehicleRepository(EntityManager entityManager) {
        super(entityManager, Vehicle.class);
    }
}
