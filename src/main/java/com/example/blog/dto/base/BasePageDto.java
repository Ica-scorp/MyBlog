package com.example.blog.dto.base;

import lombok.Data;

@Data
public class BasePageDto {
    //current page number
    Integer pageNumber = 1;

    //number of records shown
    Integer pageSize = 24;
}
