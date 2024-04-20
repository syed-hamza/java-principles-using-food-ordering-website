package com.zoggy.service;

import com.zoggy.model.Address;
import com.zoggy.model.User;
import com.zoggy.request.AddAddressRequest;
import com.zoggy.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void addAddress(AddAddressRequest req, Long userId){
        Address address = new Address();
        address.setStreet(req.getStreet());
        address.setCityName(req.getCityName());
        address.setState(req.getState());
        address.setPincode(req.getPincode());
        address.setUserId(userId);
        addressRepository.save(address);
    }

    @Override
    public Address removeAddress(Long addressId, String jwt) throws Exception {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            addressRepository.delete(address);
            return address;
        }
        return null;
    }

    @Override
    public List<Address> getAddressByUserId(User user) {
        Long id = user.getId();
        return addressRepository.findByUserId(id);
    }

    @Override
    public Address clearAddress(Long userId, String jwt) throws Exception {
        Optional<Address> optionalAddress = addressRepository.findByAddressId(userId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            Long id = address.getAddressId();
            addressRepository.deleteByAddressId(id);
            return address;
        }
        return null;
    }
}
