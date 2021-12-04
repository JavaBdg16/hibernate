package entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @EmbeddedId
    private UserKey userKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(length = 50))
    })
    private Address address;
}
