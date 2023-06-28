package com.demo.domain.LogRegPojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data

public class LoginUserVo {

    @ApiModelProperty(value = "用户昵称", required = true)
    @NotNull
    @NotBlank(message = "用户昵称不能为空")
    private String userName;
    @ApiModelProperty(value = "用户密码", required = true)
    @NotNull
    @NotBlank(message = "用户密码不能为空")
    private String password;
}
