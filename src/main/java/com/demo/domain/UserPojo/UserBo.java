package com.demo.domain.UserPojo;

import lombok.Data;

@Data
public class UserBo {

    private Long userId;
    private String nickName;
    private String userName;
    private String mobile;
    private String mailbox;
    private String password;
    private String signature;
    private String introduce;
    private Long status;
}
