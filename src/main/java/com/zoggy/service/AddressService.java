package com.zoggy.service;

import com.zoggy.model.Address;
import com.zoggy.model.User;
import com.zoggy.request.AddAddressRequest;
import java.util.List;
public interface AddressService {
    public abstract void addAddress(AddAddressRequest req, Long user);

//    public Address removeAddress(Long AddressID, String jwt)throws Exception;

    public Address clearAddress(Long userId,String jwt)throws Exception;

    public List<Address> getAddressByUserId(User user);

    public abstract void deleteAddress(Long id);
}
