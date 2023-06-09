package com.demo.service.impl;

import com.demo.domain.user.User;
import com.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Override
    public User findUserByUsername(String username) {
        User loginUser = new User();
        loginUser.setId(1L);
        loginUser.setUsername("小郝");
        loginUser.setPassword("$2a$10$J/o5Knvgorab4Ko3OUhadux5/zeysJzKEmbpRgHDRhihJFXW0a61W");
        loginUser.setSalt("111");
        return loginUser;
    }

    @Override
    public boolean registerUser(User user) {
        System.out.println(user);
        return true;
    }
}
