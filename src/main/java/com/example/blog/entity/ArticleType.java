package com.example.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章分类i
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章分类id
     */
    @TableId(value="article_type_id")
    private String articleTypeId;

    /**
     * 文章分类父id
     */
    private String articleTypeParentId;

    /**
     * 文章分类名称
     */
    private String articleTypeName;

    /**
     * 文章分类排序，越小越靠前
     */
    private Integer articleTypeSort;

    /**
     * 添加时间
     */
    private LocalDateTime articleTypeAddTime;


}
