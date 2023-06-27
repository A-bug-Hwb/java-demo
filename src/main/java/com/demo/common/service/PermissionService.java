package com.demo.common.service;

import com.demo.common.utils.SecurityUtils;
import com.demo.common.utils.StringUtils;
import com.demo.domain.LogRegPojo.LoginUser;
import com.demo.domain.RolePojo.RoleBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Component
@Service("ac")
public class PermissionService {

    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";

    /** 管理员角色权限标识 */
    private static final String SUPER_ADMIN = "admin";

    private static final String ROLE_DELIMETER = ",";

    private static final String PERMISSION_DELIMETER = ",";


    /**
     * 根据授权文件获取接口权限
     */
    public boolean hasPermi(String permission) {
        log.debug("当前权限：{} ", permission);
        return true;
    }

    /**
     * 判断用户是否拥有某个角色
     *
     * @param role 角色字符串
     * @return 用户是否具备某角色
     */
    public boolean hasRole(String role)
    {
        if (StringUtils.isEmpty(role))
        {
            return false;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getUserBo().getRoleBos()))
        {
            return false;
        }
        for (RoleBo roleBo : loginUser.getUserBo().getRoleBos())
        {
            String roleKey = roleBo.getRoleKey();
            if (SUPER_ADMIN.equals(roleKey) || roleKey.equals(StringUtils.trim(role)))
            {
                return true;
            }
        }
        return false;
    }
}
