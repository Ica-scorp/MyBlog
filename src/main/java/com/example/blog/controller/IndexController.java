package com.example.blog.controller;


import com.example.blog.entity.User;
import com.example.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private IUserService userService;
    @GetMapping("/index")
    @ResponseBody
    public String index(){
        for(User user: userService.list()){
            System.out.println(user.getUserName());
        }
        return "ok";
    }
}
