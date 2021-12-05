package wrapper;

import entity.Product;
import entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class MassiveProductWrapper extends EntityManagerWrapper {

    public MassiveProductWrapper(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void doWork(EntityManager entityManager) throws Exception {




    }
}
