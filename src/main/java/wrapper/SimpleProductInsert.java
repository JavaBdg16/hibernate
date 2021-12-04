package wrapper;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SimpleProductInsert extends EntityManagerWrapper {

    public SimpleProductInsert(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void doWork(EntityManager entityManager) throws Exception {

        Product product = new Product();
        entityManager.persist(product);
    }
}
