package com.example.blog.service.impl;

import com.example.blog.entity.ArticleTagList;
import com.example.blog.mapper.ArticleTagListMapper;
import com.example.blog.service.IArticleTagListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章对应标签 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Service
public class ArticleTagListServiceImpl extends ServiceImpl<ArticleTagListMapper, ArticleTagList> implements IArticleTagListService {

}
