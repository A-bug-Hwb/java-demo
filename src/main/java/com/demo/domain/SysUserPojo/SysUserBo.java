package com.demo.domain.SysUserPojo;

import com.demo.domain.SysRolePojo.SysRoleBo;
import lombok.Data;

import java.util.List;

@Data
public class SysUserBo {

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
    private List<SysRoleBo> sysRoleBos;
}
