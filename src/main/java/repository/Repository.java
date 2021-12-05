package repository;

import javax.persistence.EntityManager;

public abstract class Repository<T> {

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

    public T create(T t) {
        entityManager.getTransaction().begin();

        entityManager.persist(t);

        entityManager.getTransaction().commit();

        return t;
    }

    public T update(T t) {
        entityManager.getTransaction().begin();

        entityManager.persist(t);

        entityManager.getTransaction().commit();

        return t;
    }

    public void delete(T t) {
        entityManager.getTransaction().begin();

        entityManager.remove(t);

        entityManager.getTransaction().commit();
    }
}
