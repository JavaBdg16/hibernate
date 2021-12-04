import wrapper.SimpleProductInsert;
import wrapper.SimpleProductSelect;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("productPU");

        SimpleProductInsert simpleProductInsert
                = new SimpleProductInsert(entityManagerFactory);
        simpleProductInsert.init();

        SimpleProductSelect simpleProductSelect
                = new SimpleProductSelect(entityManagerFactory);
        simpleProductSelect.init();

        // dla create-drop zamknięcie połączenia spowoduje drop
        // entityManagerFactory.close();
    }
}
