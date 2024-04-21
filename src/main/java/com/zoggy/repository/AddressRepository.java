package com.zoggy.repository;

import com.zoggy.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);
    Optional<Address> findByAddressId(Long addressId);
    Optional<Address> findByPincode(String pincode);
    void delete(Address address);
    void deleteByAddressId(Long addressId);
    Address save(Address address);
//    @Query("DELETE FROM Address a WHERE a.pincode = :pincode AND a.userId = :userId")
//    void deleteByPincodeAndUserId(String pincode, Long userId);
}