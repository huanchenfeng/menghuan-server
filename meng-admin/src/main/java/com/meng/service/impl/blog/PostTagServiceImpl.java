package com.meng.service.impl.blog;

import com.meng.entity.blog.PostTag;
import com.meng.mapper.blog.PostTagMapper;
import com.meng.service.blog.IPostTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章标签关联表，实现文章与标签的多对多关系 服务实现类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Service
public class PostTagServiceImpl extends ServiceImpl<PostTagMapper, PostTag> implements IPostTagService {

}
