package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.SnowflakeIdWorker;
import com.demo.common.utils.StringUtils;
import com.demo.domain.SysRolePojo.SysRoleBo;
import com.demo.domain.SysRolePojo.SysRolePo;
import com.demo.domain.SysUserPojo.SysUserBo;
import com.demo.domain.SysUserPojo.SysUserPo;
import com.demo.domain.UserRolePojo.UserRolePo;
import com.demo.mapper.SysUserMapper;
import com.demo.service.ISysRoleService;
import com.demo.service.IUserRoleService;
import com.demo.service.ISysUserService;
import com.demo.common.utils.BeanMapHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserPo> implements ISysUserService {

    @Resource
    private SysUserMapper securityUserMapper;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private ISysRoleService iSysRoleService;

    @Override
    public SysUserBo findUserByUsername(String username) {
        SysUserBo userBo = null;
        SysUserPo securityUserPo = securityUserMapper.selectOne(Wrappers.lambdaQuery(SysUserPo.class).eq(SysUserPo::getUserName,username));
        if (StringUtils.isNotNull(securityUserPo)){
            List<Long> roleIds = iUserRoleService.list(Wrappers.lambdaQuery(UserRolePo.class).eq(UserRolePo::getUserId,securityUserPo.getUserId())).stream().map(val ->{
                return val.getRoleId();
            }).collect(Collectors.toList());
            userBo = (SysUserBo)BeanMapHelper.Bean2Bean(securityUserPo, SysUserBo.class);
            if (StringUtils.isNotEmpty(roleIds)){
                List<SysRoleBo> sysRoleBos = new ArrayList<>();
                List<SysRolePo> rolePos= iSysRoleService.list(Wrappers.lambdaQuery(SysRolePo.class).in(SysRolePo::getRoleId,roleIds));
                for (SysRolePo rolePo:rolePos){
                    SysRoleBo sysRoleBo = (SysRoleBo)BeanMapHelper.Bean2Bean(rolePo, SysRoleBo.class);
                    sysRoleBos.add(sysRoleBo);
                }
                userBo.setSysRoleBos(sysRoleBos);
            }
        }
        return userBo;
    }

    @Override
    public boolean registerUser(SysUserBo user) {
        SysUserPo userPo = (SysUserPo)BeanMapHelper.Bean2Bean(user, SysUserPo.class);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        userPo.setUid(String.valueOf(idWorker.nextId()));
        if (securityUserMapper.insert(userPo) > 0){
            return true;
        }
        return false;
    }
}
