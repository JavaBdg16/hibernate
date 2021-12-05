package entity.passenger;

import javax.persistence.Entity;

@Entity
public class ReturnTicket extends Ticket {

    private String field2;

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
