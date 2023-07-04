package com.demo.domain.UserRolePojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_role")
public class UserRolePo {

    private Long roleId;
    private Long userId;
}
