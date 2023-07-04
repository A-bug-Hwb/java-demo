package com.demo.service;

import java.util.Set;

public interface IPermissionsService {

    Set<String> getPermissions(Long userId);
}
