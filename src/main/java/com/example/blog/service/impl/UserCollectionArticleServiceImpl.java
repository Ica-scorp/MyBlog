package com.example.blog.service.impl;

import com.example.blog.entity.UserCollectionArticle;
import com.example.blog.mapper.UserCollectionArticleMapper;
import com.example.blog.service.IUserCollectionArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户收藏的文章 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Service
public class UserCollectionArticleServiceImpl extends ServiceImpl<UserCollectionArticleMapper, UserCollectionArticle> implements IUserCollectionArticleService {

}
