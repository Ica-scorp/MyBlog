package com.example.blog.mapper;

import com.example.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
