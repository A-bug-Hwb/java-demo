package com.demo.service;

import com.demo.domain.role.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findRoleByUsername(String username);

}
