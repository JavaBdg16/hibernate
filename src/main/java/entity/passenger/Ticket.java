package entity.passenger;

import javax.persistence.*;
import java.net.PasswordAuthentication;

@Entity
public abstract class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Pessenger passenger;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPassenger(Pessenger passenger) {
        this.passenger = passenger;
    }
}
