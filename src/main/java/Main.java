import entity.Product;
import entity.ProductType;
import entity.userdetails.Mobile;
import entity.userdetails.UserAddress;
import entity.userdetails.UserDetails;
import repository.MobileRepository;
import repository.ProductRepository;
import repository.UserAddressRepository;
import repository.UserDetailsRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
                    "productPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        // product();

        // UserDetails start

        UserDetailsRepository userDetailsRepository
                = new UserDetailsRepository(entityManager);

        UserAddressRepository userAddressRepository
                = new UserAddressRepository(entityManager);

        MobileRepository mobileRepository
                = new MobileRepository(entityManager);

        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("jnowak");

        UserAddress userAddress = new UserAddress();
        userAddress.setCity("Bydgoszcz");
        userAddress.setStreet("Prosta");

        userDetails.setAddress(userAddress);
        userAddress.setUserDetails(userDetails);

        // userAddressRepository.create(userAddress);
        userDetailsRepository.create(userDetails);

        UserDetails ud = userDetailsRepository.read(1L);
        UserAddress ua = ud.getAddress();

        // userDetailsRepository.delete(ud);

        ud = userDetailsRepository.read(4L);
        ua = ud.getAddress();

        ua = userAddressRepository.read(1L);

        UserDetails ud1 = new UserDetails();
        ud1.setUsername("anowak");

        UserDetails ud2 = new UserDetails();
        ud2.setUsername("jkowalczyk");

        UserDetails ud3 = new UserDetails();
        ud3.setUsername("pmalinowska");

        Mobile mobile = new Mobile();
        mobile.setBrand("Samsung");
        mobile.setModel("Galaxy S20");

        ud1.setMobile(mobile);
        ud2.setMobile(mobile);
        ud3.setMobile(mobile);

        mobile.addUserDetails(ud1);
        mobile.addUserDetails(ud2);
        mobile.addUserDetails(ud3);

        mobileRepository.create(mobile);

        ud.setMobile(mobile);
        userDetailsRepository.update(ud);

        Mobile mobile1 = mobileRepository.read(7L);

        System.out.println(mobile1.getBrand());
        System.out.println(mobile1.getModel());
        System.out.println(mobile1.getUserDetailsList());

        // UserDetails end

        // dla create-drop zamknięcie połączenia spowoduje drop
        // entityManagerFactory.close();
    }

    private static void product() {
        ProductRepository productRepository
                = new ProductRepository(entityManager);

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

            productRepository.create(product);
        }

        List<Product> products
                = productRepository.executeListResultQuery(
                "FROM Product", null);

        System.out.println("FROM Products:");
        System.out.println(products);

        products = productRepository.executeListResultQuery(
                "FROM entity.Product", null);

        System.out.println("FROM entity.Products:");
        System.out.println(products);

        products = productRepository.executeListResultQuery(
                "FROM Product AS P", null);

        System.out.println("FROM Product AS P:");
        System.out.println(products);

        products = productRepository.executeListResultQuery(
                "FROM Product P", null);

        System.out.println("FROM Product P:");
        System.out.println(products);

        List<String> productNames = productRepository.findAllNames();

        System.out.println("SELECT P.name FROM Product P");
        System.out.println(productNames);

        Product product = productRepository.executeSingleResultQuery(
                "FROM Product P WHERE P.id = 666", null);

        System.out.println("FROM Product P WHERE P.id = 666");
        System.out.println(product);

        Map<String, Object> params = new HashMap<>();
        params.put("productId", 666L);
        product = productRepository.executeSingleResultQuery(
                "FROM Product P WHERE P.id = :productId", params);

        System.out.println("FROM Product P WHERE P.id = :productId");
        System.out.println(products);
        System.out.println(product);

        params = new HashMap<>();
        params.put("name", "Całkiem nowy name");
        params.put("id", 1L);
        productRepository.executeUpdateQuery(
                "UPDATE Product P SET P.name = :name WHERE P.id = :id",
                params
        );

        System.out.println("UPDATE Product P SET P.name = :name WHERE P.id = :id");
        System.out.println(entityManager.find(Product.class, 1L));

        product = productRepository.read(2L);
        product.setName("Całkiem nowy name 2");
        productRepository.update(product);

        params = new HashMap<>();
        params.put("id", 1L);
        productRepository.executeUpdateQuery(
                "DELETE FROM Product P WHERE P.id = :id",
                params
        );

        product = productRepository.read(2L);
        productRepository.delete(product);

        productRepository.deleteById(2L);
    }
}
