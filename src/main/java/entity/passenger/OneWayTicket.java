package entity.passenger;

import javax.persistence.Entity;

@Entity
public class OneWayTicket extends Ticket {

    private String field1;

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
