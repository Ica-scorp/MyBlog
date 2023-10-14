package com.example.blog.dto.user;

import com.example.blog.dto.base.BasePageDto;
import lombok.Data;

@Data
public class UserListPageDto extends BasePageDto {
    private String userName;
}
