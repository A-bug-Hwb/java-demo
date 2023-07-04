package com.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.SysRolePojo.SysRolePo;

import java.util.Set;

public interface ISysRoleService extends IService<SysRolePo> {

    Set<String> getRoleKeys(Long userId);

}
