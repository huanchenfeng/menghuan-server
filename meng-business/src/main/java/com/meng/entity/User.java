package com.meng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表，存储用户的基本信息
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Getter
@Setter
@ApiModel(value = "User对象", description = "用户表，存储用户的基本信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID，自增主键")
    @TableId(value = "id", type = IdType.AUTO)
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
