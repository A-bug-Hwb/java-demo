package com.demo.service.impl;

import com.demo.common.utils.StringUtils;
import com.demo.domain.LogRegPojo.LoginUser;
import com.demo.domain.UserPojo.UserBo;
import com.demo.service.IRoleService;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * 用户登录认证信息查询
 *
 * @author
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username==null || username.equals("")){
            throw new RuntimeException("用户不能为空");
        }

        Set<String> Permissions = new HashSet<String>();
        // 根据用户名查询用户是否存在
        UserBo user = iUserService.findUserByUsername(username);
        if (StringUtils.isNull(user)) {
            // 用户不存在
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }else {
            // 用户存在，继续查询用户所拥有的所有权限
            Permissions = iRoleService.getRoleKeys(user.getUserId());
        }
//        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (Permissions != null && Permissions.size() > 0) {
//            // 遍历权限集合，将权限标识符添加到安全认证中心
//            for (String  nameStr : Permissions) {
//                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(nameStr);
//                grantedAuthorities.add(simpleGrantedAuthority);
//            }
//        }
        return createLoginUser(user,Permissions);
    }

    public UserDetails createLoginUser(UserBo userBo, Set<String> roleList )
    {
        return new LoginUser(userBo, roleList);
    }
}