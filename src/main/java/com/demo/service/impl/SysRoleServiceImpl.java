package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.domain.SysRolePojo.SysRolePo;
import com.demo.mapper.SysRoleMapper;
import com.demo.service.ISysRoleService;
import com.demo.service.IUserRoleService;
import com.demo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRolePo> implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private IUserRoleService iUserRoleService;


    @Override
    public Set<String> getRoleKeys(Long userId) {

        List<Long> roleIds =  iUserRoleService.getRoleIds(userId);
        if (StringUtils.isNotEmpty(roleIds)){
            Set<String> set = sysRoleMapper.selectList(Wrappers.lambdaQuery(SysRolePo.class).in(SysRolePo::getRoleId,roleIds)).stream().map(val ->{
                return val.getRoleKey();
            }).collect(Collectors.toSet());
            return set;
        }
        return null;
    }
}
