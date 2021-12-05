package repository;

import entity.userdetails.UserAddress;

import javax.persistence.EntityManager;

public class UserAddressRepository extends Repository<UserAddress> {
    
    public UserAddressRepository(EntityManager entityManager) {
        super(entityManager, UserAddress.class);
    }
}
