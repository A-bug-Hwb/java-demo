package com.demo.service;

import com.demo.domain.LogRegPojo.RegisterUser;

public interface ILogRegService {


    String login(String username,String password);

    String register(RegisterUser registerUser);
}
