package com.demo.common.service;

import com.demo.common.utils.StringUtils;
import com.demo.domain.UserPojo.UserBo;
import com.demo.service.IPermissionsService;
import com.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GetPermiInfoService {

    @Autowired
    private IPermissionsService iPermissionsService;

    @Autowired
    private IRoleService iRoleService;

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(UserBo user)
    {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (isAdmin(user))
        {
            roles.add("admin");
        }
        else
        {
            roles.addAll(iRoleService.getRoleKeys(user.getUserId()));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(UserBo user)
    {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (isAdmin(user))
        {
            perms.add("*:*:*");
        }
        else
        {
            perms.addAll(iPermissionsService.getPermissions(user.getUserId()));
        }
        return perms;
    }

    private boolean isAdmin(UserBo user){
        return StringUtils.isNotNull(user) && user.getUserId() == 1L;
    }
}
