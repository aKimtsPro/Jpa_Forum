package be.tftic.java.forum.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {

    @Column(name = "address_number")
    private int number;
    private String street;
    private int zipcode;
    private String city;
    private String country;

}
