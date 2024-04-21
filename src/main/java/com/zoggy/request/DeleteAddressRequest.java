package com.zoggy.request;

public class DeleteAddressRequest {
    private String pincode;
    public DeleteAddressRequest() {
    }

    public DeleteAddressRequest(String pincode) {
        this.pincode = pincode;
    }
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
