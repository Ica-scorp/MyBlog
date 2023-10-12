package com.example.blog.service.impl;

import com.example.blog.entity.Admin;
import com.example.blog.mapper.AdminMapper;
import com.example.blog.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
