package com.example.blog.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.user.UserListPageDto;
import com.example.blog.entity.Article;
import com.example.blog.entity.User;
import com.example.blog.service.IArticleService;
import com.example.blog.service.IArticleTagService;
import com.example.blog.service.IArticleTypeService;
import com.example.blog.service.IUserService;
import com.example.blog.utils.CommonPage;
import com.example.blog.utils.CommonResult;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.blog.dto.user.UserDto;

import java.util.Date;
import java.util.Objects;


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
        String userName=userListPageDto.getUserName();

        IPage<User> userPage= new Page<>(pageNumber, 24);
        LambdaQueryWrapper<User> userLambdaQueryWrapper= Wrappers.<User>lambdaQuery().orderByDesc(User:: getUserRegisterTime);
        userLambdaQueryWrapper.like(userName!=null, User::getUserName, userName);
        model.addAttribute("userName", userName);
        IPage<User> userIPage= userService.page(userPage, userLambdaQueryWrapper);
        model.addAttribute("userPage", CommonPage.restPage(userIPage));
        return "/admin/userlist";

    }
    /**
     * 用户修改
     *
     * @param userDto
     * @return
     */
    @PostMapping("/user/update")
    @ResponseBody
    public CommonResult userUpdate(@Valid UserDto userDto) {
        User user = userService.getById(userDto.getUserId());
        if (Objects.isNull(user)) {
            return CommonResult.failed("用户id 不正确");
        }
        Date userRegisterTime = user.getUserRegisterTime();
        String userPassword = userDto.getUserPassword();
        if (StrUtil.isNotBlank(userPassword)) {
            //用户密码 = md5（注册时间 + 用户明文密码)
            userDto.setUserPassword(SecureUtil.md5(userRegisterTime + userPassword));
        } else {
            userDto.setUserPassword(null);
        }
        BeanUtils.copyProperties(userDto, user);


        if (userService.updateById(user)) {
            return CommonResult.success("修改成功");
        }

        return CommonResult.failed("修改失败,请重试");
    }
    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @PostMapping("/user/del")
    @ResponseBody
    public CommonResult userDel(String userId) {
        if (StrUtil.isBlank(userId)) {
            return CommonResult.failed("There is an error, please refresh the page!");
        }
        if (articleService.count(Wrappers.<Article>lambdaQuery().eq(Article::getUserId, userId)) > 0) {
            return CommonResult.failed("This user has published articles, please freeze the account instead!");
        }

        if (userService.removeById(userId)) {
            return CommonResult.success("Delete Succeeds!");
        }

        return CommonResult.failed("Delete Fails!");
    }
    



}
