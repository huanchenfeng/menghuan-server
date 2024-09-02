package com.meng.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.core.domain.R;
import com.meng.dto.LoginDto;
import com.meng.entity.User;
import com.meng.mapper.UserMapper;
import com.meng.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，存储用户的基本信息 服务实现类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public R login(LoginDto loginDto) {
        String password=loginDto.getPassword();
        String username=loginDto.getUsername();
        User user=this.getOne(new QueryWrapper<User>().eq("username",username));
        if (BeanUtil.isEmpty(user)||!user.getPassword().equals(password))
            return R.warn("账号或密码错误");
        return R.ok(user);
    }
}
