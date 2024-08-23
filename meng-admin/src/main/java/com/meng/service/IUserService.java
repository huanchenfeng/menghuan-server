package com.meng.service;

import com.meng.core.domain.R;
import com.meng.dto.LoginDto;
import com.meng.dto.UserDto;
import com.meng.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.vo.UserVo;

/**
 * <p>
 * 用户表，存储用户的基本信息 服务类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
public interface IUserService extends IService<User> {

    R login(LoginDto loginDto);
}
