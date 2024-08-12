package com.meng.service.blog;

import com.meng.entity.blog.PostTag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章标签关联表，实现文章与标签的多对多关系 服务类
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
public interface IPostTagService extends IService<PostTag> {

}
