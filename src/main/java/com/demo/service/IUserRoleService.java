package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.UserRolePojo.UserRolePo;

import java.util.List;

public interface IUserRoleService extends IService<UserRolePo> {

    List<Long> getRoleIds(Long userId);
}
