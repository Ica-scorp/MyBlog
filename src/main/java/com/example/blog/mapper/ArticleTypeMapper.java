package com.example.blog.mapper;

import com.example.blog.entity.ArticleType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 文章分类i Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Repository
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {

}
