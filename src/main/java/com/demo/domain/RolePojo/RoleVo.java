package com.demo.domain.RolePojo;

import lombok.Data;

@Data
public class RoleVo {

    private Long roleId;
    private String roleName;
    private String roleKey;
    private Long sort;
    private Long status;
}