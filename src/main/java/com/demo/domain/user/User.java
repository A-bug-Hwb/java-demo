package com.demo.domain.user;

import lombok.Data;

@Data
public class User {

    private Long id;

    /**
     * 用户名：这是数据库的字段，
     * 是userName或者是account就写对应的字段
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    private String salt;
}
