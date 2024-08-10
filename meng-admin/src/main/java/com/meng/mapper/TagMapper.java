package com.meng.mapper;

import com.meng.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签表，存储文章的标签信息 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
