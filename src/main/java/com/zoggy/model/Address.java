package com.zoggy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id", unique = true, nullable = false)
    private Long addressId;

    // Getters and setters
    private Long userId;
    private String street;
    private String cityName;
    private String state;
    private String pincode;

    public Address() {
    }
    // Constructors
    public Address(Long addressid,Long userId, String street, String cityName, String state, String pincode) {
        this.addressId = addressid;
        this.userId = userId;
        this.street = street;
        this.cityName = cityName;
        this.state = state;
        this.pincode = pincode;
    }

}
