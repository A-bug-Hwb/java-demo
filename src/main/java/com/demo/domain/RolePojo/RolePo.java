package com.demo.domain.RolePojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("security_role")
public class RolePo {

    private Long roleId;
    private String roleName;
    private String roleKey;
    private Long sort;
    private Long status;
}
