package com.demo.domain.UserPojo;

import lombok.Data;

@Data
public class UserVo {

    private Long userId;
    private String uid;
    private String nickName;
    private String userName;
    private String mobile;
    private String mailbox;
    private String signature;
    private String introduce;
    private Long status;
}
