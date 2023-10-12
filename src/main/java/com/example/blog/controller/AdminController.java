package com.example.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Title: AdminController
 * @create 2021/12/20 22:44
 */

@Controller
@RequestMapping("/Ica269")
public class AdminController {

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("/admin")
    public String adminIndex() {

        return "/admin/index";
    }



}
