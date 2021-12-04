import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class EntityManagerWrapper {

    public abstract void doWork() throws Exception;

    public void init() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("productPU");

        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            doWork();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManagerFactory.close();
        }
    }
}
