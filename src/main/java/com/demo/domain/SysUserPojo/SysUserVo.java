package com.demo.domain.SysUserPojo;

import lombok.Data;

@Data
public class SysUserVo {

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
