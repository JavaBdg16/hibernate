package entity.passenger;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pessenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
