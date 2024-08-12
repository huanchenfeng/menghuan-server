package com.meng.mapper.blog;

import com.meng.entity.blog.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论表，存储文章的评论信息 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
