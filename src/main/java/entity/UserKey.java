package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserKey implements Serializable {

    private String  firstName;

    private String lastName;
}
