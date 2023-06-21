package com.demo.domain.UserPojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.domain.BaseEntity.BaseEntity;
import lombok.Data;

@Data
@TableName("security_user")
public class UserPo extends BaseEntity {

    private Long userId;
    private String uid;
    private String nickName;
    private String userName;
    private String mobile;
    private String mailbox;
    private String password;
    private String signature;
    private String introduce;
    private Long status;
}
