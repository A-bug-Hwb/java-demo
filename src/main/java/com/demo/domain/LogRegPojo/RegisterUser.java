package com.demo.domain.LogRegPojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户注册")
public class RegisterUser {

    @ApiModelProperty(value = "用户昵称", required = true)
    @NotNull
    @NotBlank(message = "用户昵称不能为空")
    @Length(min=2, max=20,message = "账户长度必须在2到20个字符之间")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "用户昵称", required = true)
    @NotNull
    @NotBlank(message = "密码不能为空")
    @Length(min=5, max=20,message = "密码长度必须在5到20个字符之间")
    private String password;

    @ApiModelProperty(value = "用户昵称", required = true)
    @NotNull
    @NotBlank(message = "密码不能为空")
    @Length(min=5, max=20,message = "密码长度必须在5到20个字符之间")
    private String confirmPassword;
}
