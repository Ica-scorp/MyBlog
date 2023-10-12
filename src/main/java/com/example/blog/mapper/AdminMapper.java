package com.example.blog.mapper;

import com.example.blog.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
