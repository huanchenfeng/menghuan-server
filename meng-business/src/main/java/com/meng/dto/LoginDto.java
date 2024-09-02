package com.meng.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDto {
    @ApiModelProperty("用户名，必须唯一")
    private String username;
    @ApiModelProperty("用户密码，使用加密后的字符串")
    private String password;

}
