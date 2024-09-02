package com.meng.service.impl.blog;

import com.meng.entity.blog.Post;
import com.meng.mapper.blog.PostMapper;
import com.meng.service.blog.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表，存储博客文章的内容和作者信息 服务实现类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
