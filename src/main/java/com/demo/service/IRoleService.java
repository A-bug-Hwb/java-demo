package com.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.RolePojo.RolePo;

import java.util.Set;

public interface IRoleService extends IService<RolePo> {

    Set<String> getRoleKeys(Long userId);

}
