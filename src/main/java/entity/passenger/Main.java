package entity.passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "productPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        Pessenger passenger = new Pessenger();
        passenger.setName("Jan Nowak");
        passenger.setAddress("JHDKSAJHFAKJSdfhkj");

        List<Ticket> tickets = new ArrayList<>();

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("123456");
        oneWayTicket.setPassenger(passenger);
        oneWayTicket.setField1("FIELD 1");

        ReturnTicket returnTicket = new ReturnTicket();
        returnTicket.setNumber("0986753");
        returnTicket.setPassenger(passenger);
        returnTicket.setField2("FIELD 2");

        tickets.add(oneWayTicket);
        tickets.add(returnTicket);

        passenger.setTickets(tickets);

        entityManager.getTransaction().begin();
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("FROM Ticket");
        List<Ticket> tickets2 = query.getResultList();

        Ticket oneWayTicket1 = (Ticket) entityManager.createQuery(
                "FROM Ticket WHERE id = 2").getSingleResult();
    }
}
