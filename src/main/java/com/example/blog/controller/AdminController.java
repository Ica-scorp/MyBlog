package com.example.blog.controller;


import cn.hutool.system.HostInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.user.UserListPageDto;
import com.example.blog.entity.User;
import com.example.blog.service.IArticleService;
import com.example.blog.service.IArticleTagService;
import com.example.blog.service.IArticleTypeService;
import com.example.blog.service.IUserService;
import com.example.blog.utils.CommonPage;
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
     * log -in page
     *
     * @return
     */
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IArticleTagService articleTagService;
    @Autowired
    private IArticleTypeService articleTypeService;
    @Autowired
    private IUserService userService;
    @GetMapping("/admin")
    public String adminIndex(Model model) {

        OsInfo osInfo=SystemUtil.getOsInfo();
        HostInfo hostInfo=SystemUtil.getHostInfo();
        model.addAttribute("osName",osInfo.getName() );
        model.addAttribute("hostName",hostInfo.getAddress());
        long articleTypeCount= articleTypeService.count();
        long articleTagCount=articleTagService.count();
        long articleCount=articleService.count();
        model.addAttribute("articleTypeCount",articleTypeCount );
        model.addAttribute("articleTagCount",articleTagCount );
        model.addAttribute("articleCount",articleCount );
        long userCount=userService.count();
        model.addAttribute("userCount",userCount );

        return "/admin/index";
    }

    /**
     * admin side: user list
     *
     * @return
     */

    @GetMapping("/user/list")
    public String userList(UserListPageDto userListPageDto, Model model){
        Integer pageNumber = userListPageDto.getPageNumber();

        Integer pageSize = userListPageDto.getPageSize();
        IPage<User> userPage= new Page<>(pageNumber, pageSize);
        LambdaQueryWrapper<User> userLambdaQueryWrapper= Wrappers.<User>lambdaQuery().orderByDesc(User:: getUserRegisterTime);
        IPage<User> userIPage= userService.page(userPage, userLambdaQueryWrapper);
        model.addAttribute("userPage", CommonPage.restPage(userIPage));
        return "/admin/userlist";

    }


}
