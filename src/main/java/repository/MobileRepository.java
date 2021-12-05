package repository;

import entity.userdetails.Mobile;

import javax.persistence.EntityManager;

public class MobileRepository extends Repository<Mobile> {
    public MobileRepository(EntityManager entityManager) {
        super(entityManager, Mobile.class);
    }
}
