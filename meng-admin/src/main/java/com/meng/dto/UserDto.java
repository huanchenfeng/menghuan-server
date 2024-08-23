package com.meng.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    @ApiModelProperty("用户ID，自增主键")
    private Long id;

    @ApiModelProperty("用户名，必须唯一")
    private String username;

    @ApiModelProperty("邮箱地址，必须唯一")
    private String email;

    @ApiModelProperty("用户密码，使用加密后的字符串")
    private String password;

    @ApiModelProperty("用户注册时间")
    private LocalDateTime createdAt;

    @ApiModelProperty("用户信息最后更新时间")
    private LocalDateTime updatedAt;
}
