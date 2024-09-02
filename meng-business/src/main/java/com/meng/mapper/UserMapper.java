package com.meng.mapper;

import com.meng.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表，存储用户的基本信息 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
