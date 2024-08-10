package com.meng.service.impl;

import com.meng.entity.PostTag;
import com.meng.mapper.PostTagMapper;
import com.meng.service.IPostTagService;
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
