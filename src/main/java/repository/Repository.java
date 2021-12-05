package repository;

import javax.persistence.EntityManager;

public class Repository<T> {

    private final EntityManager entityManager;
    private final Class<T> typeParameterClass;

    public Repository(EntityManager entityManager, Class<T> typeParameterClass) {
        this.entityManager = entityManager;
        this.typeParameterClass = typeParameterClass;
    }

    public T read(long id) {
        T result = entityManager.find(typeParameterClass, id);
        return result;
    }

    public void create(T t) {
//        if (product.getId() != 0) {
//            throw new IllegalArgumentException("Entity exists");
//        }

        entityManager.getTransaction().begin();

        entityManager.persist(t);

        entityManager.getTransaction().commit();
    }

    public void update(T t) {
//        if (product.getId() == 0) {
//            throw new IllegalArgumentException("Entity has no key");
//        }

        entityManager.getTransaction().begin();

        entityManager.persist(t);

        entityManager.getTransaction().commit();
    }

    public void delete(T t) {
        entityManager.getTransaction().begin();

        entityManager.remove(t);

        entityManager.getTransaction().commit();
    }
}
