package com.zoggy.service;

import com.zoggy.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt);

    public User findUserByEmail(String email);
}
