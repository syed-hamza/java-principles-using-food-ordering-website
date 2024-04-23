package com.zoggy.request;

public class DeleteAddressRequest {
    private Long addressId;
    public DeleteAddressRequest() {
    }

    public DeleteAddressRequest(Long addressId) {
        this.addressId = addressId;
    }
    public Long getid() {
        return this.addressId;
    }

    public void setid(Long addressId) {
        this.addressId = addressId;
    }
}
