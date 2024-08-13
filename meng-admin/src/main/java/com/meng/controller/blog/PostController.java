package com.meng.controller.blog;

import com.github.pagehelper.PageHelper;
import com.meng.core.domain.R;
import com.meng.service.blog.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文章表，存储博客文章的内容和作者信息 前端控制器
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;
    @RequestMapping("/list")
    public R list() {
        PageHelper.startPage(1,10);
        return R.ok(postService.list());
    }
}
