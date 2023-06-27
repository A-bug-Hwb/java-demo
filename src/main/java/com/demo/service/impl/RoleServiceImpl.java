package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.domain.RolePojo.RolePo;
import com.demo.mapper.RoleMapper;
import com.demo.service.IRoleService;
import com.demo.service.IUserRoleService;
import com.demo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,RolePo> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private IUserRoleService iUserRoleService;


    @Override
    public Set<String> getRoleKeys(Long userId) {

        List<Long> roleIds =  iUserRoleService.getRoleIds(userId);
        if (StringUtils.isNotEmpty(roleIds)){
            Set<String> set = roleMapper.selectList(Wrappers.lambdaQuery(RolePo.class).in(RolePo::getRoleId,roleIds)).stream().map(val ->{
                return val.getRoleKey();
            }).collect(Collectors.toSet());
            return set;
        }
        return null;
    }
}
