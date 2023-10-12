package com.example.blog.mapper;

import com.example.blog.entity.Link;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 友情连接 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Repository
public interface LinkMapper extends BaseMapper<Link> {

}