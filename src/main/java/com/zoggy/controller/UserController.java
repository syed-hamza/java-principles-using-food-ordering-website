package com.zoggy.controller;

import com.zoggy.model.Address;
import com.zoggy.model.User;
import com.zoggy.request.AddAddressRequest;
import com.zoggy.service.AddressService;
import com.zoggy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/addresses")
//    public ResponseEntity<List<Address>> getAllAddresses(@RequestHeader("Authorization") String jwt) {
//        List<Address> addresses = addressService.getAllAddresses(jwt);
//        return new ResponseEntity<>(addresses, HttpStatus.OK);
//    }

}
