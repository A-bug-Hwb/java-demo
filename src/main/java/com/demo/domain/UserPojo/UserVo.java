package com.demo.domain.UserPojo;

import lombok.Data;

@Data
public class UserVo {

    /**
     * 用户名：这是数据库的字段，
     * 是userName或者是account就写对应的字段
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
