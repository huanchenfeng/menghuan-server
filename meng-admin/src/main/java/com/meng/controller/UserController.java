package com.meng.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.core.domain.R;
import com.meng.dto.LoginDto;
import com.meng.dto.UserDto;
import com.meng.entity.User;
import com.meng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表，存储用户的基本信息 前端控制器
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/login")
    public R login(LoginDto loginDto) {
        System.out.println("进入");
        return userService.login(loginDto);
    }
    @RequestMapping("/regist")
    public R regist() {
        User user=userService.getOne(new QueryWrapper<User>().eq("username", "admin").eq("password", "123456"));
        if(ObjectUtils.isEmpty(user)) {
            return R.fail("密码错误");
        }
        return R.ok();
    }
}
