package entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address {
    private String street;
    private String number;
    private String zipZode;
    private String city;
}
