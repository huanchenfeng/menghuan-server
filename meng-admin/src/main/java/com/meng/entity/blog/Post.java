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
 * 文章表，存储博客文章的内容和作者信息
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-10 17:10:15
 */
@Getter
@Setter
@ApiModel(value = "Post对象", description = "文章表，存储博客文章的内容和作者信息")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章ID，自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容，存储文本数据")
    private String content;

    @ApiModelProperty("作者ID，指向用户表中的ID")
    private Long userId;

    @ApiModelProperty("分类ID，指向分类表中的ID")
    private Long categoryId;

    @ApiModelProperty("文章创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty("文章最后更新时间")
    private LocalDateTime updatedAt;
}
