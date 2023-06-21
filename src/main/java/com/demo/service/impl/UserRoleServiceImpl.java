package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.StringUtils;
import com.demo.domain.UserRolePojo.UserRolePo;
import com.demo.mapper.UserRoleMapper;
import com.demo.service.IUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRolePo> implements IUserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<Long> getRoleIds(Long userId){
        List<Long> roleIds = userRoleMapper.selectList(Wrappers.lambdaQuery(UserRolePo.class).eq(UserRolePo::getUserId,userId)).stream().map(val ->{
            return val.getRoleId();
        }).collect(Collectors.toList());
        return roleIds;
    }
}
