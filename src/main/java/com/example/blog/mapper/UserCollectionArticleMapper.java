package com.example.blog.mapper;

import com.example.blog.entity.UserCollectionArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户收藏的文章 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Mapper
public interface UserCollectionArticleMapper extends BaseMapper<UserCollectionArticle> {

}
