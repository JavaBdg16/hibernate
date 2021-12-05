package entity.userdetails;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    // TODO: @OneToOne - LAZY, czemu nie działa?
    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
    // @Fetch(FetchMode.SELECT)
//    @JoinTable(
//            name = "userdetails_to_useraddress",
//            joinColumns = { @JoinColumn(name = "userDetailsId", referencedColumnName = "id")},
//            inverseJoinColumns = { @JoinColumn(name = "userAddressId", referencedColumnName = "id")}
//    )
    private UserAddress address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MobileId")
    private Mobile mobile;

    @ManyToMany(mappedBy = "userDetailsList", cascade = CascadeType.ALL)
    private List<Vehicle> vehicleList;

    public UserDetails() {
        vehicleList = new ArrayList<>();
    }

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

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
}
