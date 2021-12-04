import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("productPU");

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // do some work

        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
