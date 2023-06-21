package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.SnowflakeIdWorker;
import com.demo.common.utils.StringUtils;
import com.demo.domain.UserPojo.UserBo;
import com.demo.domain.UserPojo.UserPo;
import com.demo.mapper.UserMapper;
import com.demo.service.IUserService;
import com.demo.common.utils.BeanMapHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements IUserService  {

    @Resource
    private UserMapper securityUserMapper;

    @Override
    public UserBo findUserByUsername(String username) {
        UserPo securityUserPo = securityUserMapper.selectOne(Wrappers.lambdaQuery(UserPo.class).eq(UserPo::getUserName,username));
        if (StringUtils.isNotNull(securityUserPo)){
            return (UserBo)BeanMapHelper.Bean2Bean(securityUserPo, UserBo.class);
        }
        return null;
    }

    @Override
    public boolean registerUser(UserBo user) {
        UserPo userPo = (UserPo)BeanMapHelper.Bean2Bean(user, UserPo.class);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        userPo.setUid(String.valueOf(idWorker.nextId()));
        if (securityUserMapper.insert(userPo) > 0){
            return true;
        }
        return false;
    }
}
