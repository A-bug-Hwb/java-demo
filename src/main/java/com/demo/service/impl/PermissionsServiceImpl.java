package com.demo.service.impl;

import com.demo.domain.UserPojo.UserBo;
import com.demo.service.IPermissionsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PermissionsServiceImpl implements IPermissionsService {


    @Override
    public Set<String> getPermissions(Long userId) {
        Set<String> set = new HashSet<>();
        set.add("menu:user:list");
        set.add("menu:user:update");
        return set;
    }
}
