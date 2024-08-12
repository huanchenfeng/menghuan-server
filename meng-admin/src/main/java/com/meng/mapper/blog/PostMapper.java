package com.meng.mapper.blog;

import com.meng.entity.blog.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章表，存储博客文章的内容和作者信息 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
