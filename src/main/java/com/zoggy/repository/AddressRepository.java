package com.zoggy.repository;

import com.zoggy.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);
    Optional<Address> findByAddressId(Long addressId);
    void deleteByAddressId(Long addressId);
    Address save(Address address);
}