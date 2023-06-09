package com.demo.service;

import com.demo.domain.user.User;


public interface IUserService {

    User findUserByUsername(String username);

    boolean registerUser(User user);
}
