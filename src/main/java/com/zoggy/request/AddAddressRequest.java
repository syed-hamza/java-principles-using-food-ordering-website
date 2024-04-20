package com.zoggy.request;

public class AddAddressRequest {
    private String street;
    private String cityName;
    private String state;
    private String pincode;

    // Constructors

    public AddAddressRequest() {
    }

    public AddAddressRequest(String street, String cityName, String state, String pincode) {
        this.street = street;
        this.cityName = cityName;
        this.state = state;
        this.pincode = pincode;
    }

    // Getters and setters

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
