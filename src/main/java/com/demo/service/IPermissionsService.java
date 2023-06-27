package com.demo.service;

import com.demo.domain.UserPojo.UserBo;

import java.util.Set;

public interface IPermissionsService {

    Set<String> getPermissions(Long userId);
}
