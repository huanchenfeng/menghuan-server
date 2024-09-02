package com.meng.entity.blog;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文章标签关联表，实现文章与标签的多对多关系
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Getter
@Setter
@TableName("post_tag")
@ApiModel(value = "PostTag对象", description = "文章标签关联表，实现文章与标签的多对多关系")
public class PostTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章ID，指向文章表中的ID")
    @TableId("post_id")
    private Long postId;

    @ApiModelProperty("标签ID，指向标签表中的ID")
//    @TableId("tag_id")
    private Long tagId;
}
