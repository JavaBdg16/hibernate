package wrapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class EntityManagerWrapper {

    private final EntityManagerFactory entityManagerFactory;

    public abstract void doWork(EntityManager entityManager) throws Exception;

    public EntityManagerWrapper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void init() {

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            doWork(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
