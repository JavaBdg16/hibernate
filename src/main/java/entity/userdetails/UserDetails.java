package entity.userdetails;

import javax.persistence.*;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "userdetails_to_useraddress",
//            joinColumns = { @JoinColumn(name = "userDetailsId", referencedColumnName = "id")},
//            inverseJoinColumns = { @JoinColumn(name = "userAddressId", referencedColumnName = "id")}
//    )
    private UserAddress address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }
}
