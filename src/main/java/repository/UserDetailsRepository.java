package repository;

import entity.userdetails.UserDetails;

import javax.persistence.EntityManager;

public class UserDetailsRepository extends Repository<UserDetails> {

    public UserDetailsRepository(EntityManager entityManager) {
        super(entityManager, UserDetails.class);
    }
}
