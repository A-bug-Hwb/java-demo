package com.demo.domain.UserPojo;

import com.demo.domain.RolePojo.RoleBo;
import lombok.Data;

import java.util.List;

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

    /** 角色对象 */
    private List<RoleBo> roleBos;
}
