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
        if(!userService.list().isEmpty()){
            for(User user: userService.list()){
                System.out.println(user.getUserId());
//                if(user==null){
//                    System.out.println("nullptr");
//                }else{
//                    System.out.println(user.getUserId());
//                }

            }
            return "empty";
        }
//        for(User user: userService.list()){
//            System.out.println(user.getUserName());
//        }
        return "haha";
    }
}
