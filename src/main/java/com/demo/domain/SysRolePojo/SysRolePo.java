package com.demo.domain.SysRolePojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role")
public class SysRolePo {

    private Long roleId;
    private String roleName;
    private String roleKey;
    private Long sort;
    private Long status;
}
