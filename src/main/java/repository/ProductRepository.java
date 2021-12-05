package repository;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Product product) {
        if (product.getId() != 0) {
            throw new IllegalArgumentException("Entity exists");
        }

        entityManager.getTransaction().begin();

        entityManager.persist(product);

        entityManager.getTransaction().commit();
    }

    public Product read(long id) {
        // TODO: T.class
        return entityManager.find(Product.class, id);
    }

    public void update(Product product) {
        if (product.getId() == 0) {
            throw new IllegalArgumentException("Entity has no key");
        }

        entityManager.getTransaction().begin();

        entityManager.persist(product);

        entityManager.getTransaction().commit();
    }

    public void delete(Product product) {
        entityManager.getTransaction().begin();

        entityManager.remove(product);

        entityManager.getTransaction().commit();
    }

    public void deleteById(long id) {
        entityManager.getTransaction().begin();

        Product product = read(id);
        if (product != null) {
            entityManager.remove(product);
        }

        entityManager.getTransaction().commit();
    }

    public Product findByName(String name) {
        Query query = entityManager.createQuery("FROM Product P WHERE P.name = :name");
        query.setParameter("name", name);
        Product product = (Product) query.getSingleResult();
        return product;
    }

    public List<String> findAllNames() {
        Query query = entityManager.createQuery(
                "SELECT P.name FROM Product P");
        List<String> productNames = query.getResultList();

        return productNames;
    }

    /**
     * W świecie produkcyjnym tego typu metoda nie powinna istnieć
     * Metoda wyłącznie do celów szkoleniowych, do wywoływania zapytań HQL
     * @param query
     * @return
     */
    public List<Product> executeListResultQuery(String queryStr, Map<String, Object> parameters) {
        Query query = entityManager.createQuery(queryStr);
        if (parameters != null) {
            parameters.forEach((k, v) -> query.setParameter(k, v));
        }
        List<Product> result = query.getResultList();

        return result;
    }

    /**
     * W świecie produkcyjnym tego typu metoda nie powinna istnieć
     * Metoda wyłącznie do celów szkoleniowych, do wywoływania zapytań HQL
     * @param query
     * @return
     */
    public Product executeSingleResultQuery(String queryStr, Map<String, Object> parameters) {
        Query query = entityManager.createQuery(queryStr);
        if (parameters != null) {
            parameters.forEach((k, v) -> query.setParameter(k, v));
        }
        Product result = (Product) query.getSingleResult();

        return result;
    }

    public void executeUpdateQuery(String queryStr, Map<String, Object> parameters) {
        Query query = entityManager.createQuery(queryStr);
        if (parameters != null) {
            parameters.forEach((k, v) -> query.setParameter(k, v));
        }

        query.executeUpdate();
    }
}
