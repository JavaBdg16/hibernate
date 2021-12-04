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

        for (int i = 1; i <= 1000; i++) {

            Product product = new Product();
            product.setName("Produkt numer "  + i);
            if (i % 3 == 0) {
                product.setProductType(ProductType.FOOD);
            } else  if (i % 3 == 1) {
                product.setProductType(ProductType.MATERIAL);
            } else {
                product.setProductType(ProductType.TOOL);
            }

            entityManager.persist(product);
        }

        Query query = entityManager.createQuery("FROM Product");
        List<Product> products = query.getResultList();

        System.out.println("FROM Products:");
        System.out.println(products);

        query = entityManager.createQuery("FROM entity.Product");
        products = query.getResultList();

        System.out.println("FROM entity.Products:");
        System.out.println(products);

        query = entityManager.createQuery("FROM Product AS P");
        products = query.getResultList();

        System.out.println("FROM Product AS P:");
        System.out.println(products);

        query = entityManager.createQuery("FROM Product P");
        products = query.getResultList();

        System.out.println("FROM Product P:");
        System.out.println(products);

        query = entityManager.createQuery("SELECT P.name FROM Product P");
        List<String> productNames = query.getResultList();

        System.out.println("SELECT P.name FROM Product P");
        System.out.println(productNames);

        query = entityManager.createQuery("FROM Product P WHERE P.id = 666");
        Product product = (Product) query.getSingleResult();

        System.out.println("FROM Product P WHERE P.id = 666");
        System.out.println(product);

        query = entityManager.createQuery("FROM Product P WHERE P.id = :productId");
        query.setParameter("productId", 666L);
        products = query.getResultList();
        product = (Product) query.getSingleResult();

        System.out.println("FROM Product P WHERE P.id = :productId");
        System.out.println(products);
        System.out.println(product);

        query = entityManager.createQuery(
                "UPDATE Product P SET P.name = :name WHERE P.id = :id");
        query.setParameter("name", "Całkiem nowy name");
        query.setParameter("id", 1L);
        query.executeUpdate();

        System.out.println("UPDATE Product P SET P.name = :name WHERE P.id = :id");
        System.out.println(entityManager.find(Product.class, 1L));

        product = entityManager.find(Product.class, 2L);
        product.setName("Całkiem nowy name 2");
        entityManager.persist(product);
    }
}
