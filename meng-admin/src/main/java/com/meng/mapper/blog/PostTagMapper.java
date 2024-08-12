package com.meng.mapper.blog;

import com.meng.entity.blog.PostTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章标签关联表，实现文章与标签的多对多关系 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Mapper
public interface PostTagMapper extends BaseMapper<PostTag> {

}
