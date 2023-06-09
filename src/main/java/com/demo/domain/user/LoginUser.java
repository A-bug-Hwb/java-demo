package com.demo.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uuid;

    /**
     * 用户名：这是数据库的字段，
     * 是userName或者是account就写对应的字段
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    private String salt;
    /**
     *  权限集合
     */

    private List<String> roleList;

//    private Collection<? extends GrantedAuthority> authorities;

    public LoginUser(){

    }

    public LoginUser(Long id, String username, String password, String salt, List<String> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.roleList = roleList;
    }

    /**无论我数据库里的字段是 `account`，或者username，或者userName，或者其他代表账户的字段,
     * 这里还是要写成 `getUsername()`,因为是继承的接口
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    /**
     * 返回给用户的角色列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账户是否未过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     *账户是否未锁定
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     *密码是否未过期
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     *账户是否激活
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
