package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.UserPojo.UserBo;
import com.demo.domain.UserPojo.UserPo;


public interface IUserService extends IService<UserPo> {

    UserBo findUserByUsername(String username);

    boolean registerUser(UserBo user);
}
