package wrapper;

import entity.userdetails.UserAddress;
import entity.userdetails.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserDetailsWrapper extends EntityManagerWrapper {
    public UserDetailsWrapper(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void doWork(EntityManager entityManager) throws Exception {
        UserAddress userAddress = new UserAddress();
        userAddress.setCity("Bydgoszcz");
        userAddress.setStreet("Jakakolwiek");

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("anowak");

        userDetails.setAddress(userAddress);
        userAddress.setUserDetails(userDetails);

        entityManager.persist(userAddress);
        entityManager.persist(userDetails);

        UserDetails ud = entityManager.find(UserDetails.class, 1L);
        UserAddress ua = ud.getAddress();
        UserDetails ud2 = ua.getUserDetails();
    }
}
