package com.demo.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@Service("ac")
public class PermissionService {
    /**
     * 根据授权文件获取接口权限
     */
    public boolean hasPermi(String permission) {
        log.debug("当前权限：{} ", permission);
        return true;
    }
}
