package repository;

import entity.userdetails.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDetailsRepository extends Repository<UserDetails> {

    private final EntityManager entityManager;

    public UserDetailsRepository(EntityManager entityManager) {
        super(entityManager, UserDetails.class);
        this.entityManager = entityManager;
    }

    public List<UserDetails> findAll() {
        Query query = entityManager.createQuery("FROM UserDetails");
        return query.getResultList();
    }
}
