package wrapper;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SimpleProductSelect extends EntityManagerWrapper {

    public SimpleProductSelect(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void doWork(EntityManager entityManager) throws Exception {

        Product product = entityManager.find(Product.class, 1L);
        System.out.println(product);
    }
}
