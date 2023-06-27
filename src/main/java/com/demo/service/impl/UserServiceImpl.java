package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.SnowflakeIdWorker;
import com.demo.common.utils.StringUtils;
import com.demo.domain.RolePojo.RoleBo;
import com.demo.domain.RolePojo.RolePo;
import com.demo.domain.UserPojo.UserBo;
import com.demo.domain.UserPojo.UserPo;
import com.demo.domain.UserRolePojo.UserRolePo;
import com.demo.mapper.UserMapper;
import com.demo.service.IRoleService;
import com.demo.service.IUserRoleService;
import com.demo.service.IUserService;
import com.demo.common.utils.BeanMapHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements IUserService  {

    @Resource
    private UserMapper securityUserMapper;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IRoleService iRoleService;

    @Override
    public UserBo findUserByUsername(String username) {
        UserBo userBo = null;
        UserPo securityUserPo = securityUserMapper.selectOne(Wrappers.lambdaQuery(UserPo.class).eq(UserPo::getUserName,username));
        if (StringUtils.isNotNull(securityUserPo)){
            List<Long> roleIds = iUserRoleService.list(Wrappers.lambdaQuery(UserRolePo.class).eq(UserRolePo::getUserId,securityUserPo.getUserId())).stream().map(val ->{
                return val.getRoleId();
            }).collect(Collectors.toList());
            userBo = (UserBo)BeanMapHelper.Bean2Bean(securityUserPo, UserBo.class);
            if (StringUtils.isNotEmpty(roleIds)){
                List<RoleBo> roleBos = new ArrayList<>();
                List<RolePo> rolePos= iRoleService.list(Wrappers.lambdaQuery(RolePo.class).in(RolePo::getRoleId,roleIds));
                for (RolePo rolePo:rolePos){
                    RoleBo roleBo = (RoleBo)BeanMapHelper.Bean2Bean(rolePo, RoleBo.class);
                    roleBos.add(roleBo);
                }
                userBo.setRoleBos(roleBos);
            }
        }
        return userBo;
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
