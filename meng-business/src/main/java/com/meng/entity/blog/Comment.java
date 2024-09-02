package com.meng.entity.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 评论表，存储文章的评论信息
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Getter
@Setter
@ApiModel(value = "Comment对象", description = "评论表，存储文章的评论信息")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论ID，自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章ID，指向评论所对应的文章")
    private Long postId;

    @ApiModelProperty("用户ID，指向发表评论的用户")
    private Long userId;

    @ApiModelProperty("评论内容，存储评论文本")
    private String content;

    @ApiModelProperty("评论创建时间")
    private LocalDateTime createdAt;
}
