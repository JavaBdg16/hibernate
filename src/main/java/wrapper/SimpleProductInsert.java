package wrapper;

import entity.Product;
import entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SimpleProductInsert extends EntityManagerWrapper {

    public SimpleProductInsert(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void doWork(EntityManager entityManager) throws Exception {

        Product product = new Product();
        product.setName("Produkt numer 1");
        product.setProductType(ProductType.TOOL);
        entityManager.persist(product);
    }
}
