package com.meng.service.impl.blog;

import com.meng.entity.blog.Tag;
import com.meng.mapper.blog.TagMapper;
import com.meng.service.blog.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表，存储文章的标签信息 服务实现类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
