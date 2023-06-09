package com.demo.service.impl;

import com.demo.domain.role.Role;
import com.demo.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {


    @Override
    public List<Role> findRoleByUsername(String username) {
        List<Role> list = new ArrayList<>();
        Role role = new Role();
        role.setId(1L);
        role.setUsername("小郝");
        role.setName("admin");
        list.add(role);
        Role role1 = new Role();
        role1.setId(2L);
        role1.setUsername("小郝");
        role1.setName("role");
        list.add(role1);
        return list;
    }

}
