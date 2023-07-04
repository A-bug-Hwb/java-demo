package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.SysUserPojo.SysUserBo;
import com.demo.domain.SysUserPojo.SysUserPo;


public interface ISysUserService extends IService<SysUserPo> {

    SysUserBo findUserByUsername(String username);

    boolean registerUser(SysUserBo user);
}
