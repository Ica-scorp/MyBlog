package com.example.blog.service.impl;

import com.example.blog.entity.AdType;
import com.example.blog.mapper.AdTypeMapper;
import com.example.blog.service.IAdTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告类型 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Service
public class AdTypeServiceImpl extends ServiceImpl<AdTypeMapper, AdType> implements IAdTypeService {

}
