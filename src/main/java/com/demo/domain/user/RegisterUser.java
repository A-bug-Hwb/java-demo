package com.demo.domain.user;

import lombok.Data;

@Data
public class RegisterUser {

    private String username;

    /**
     * 密码
     */
    private String password;

    private String confirmPassword;
}
