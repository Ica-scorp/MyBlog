package com.example.blog;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.blog.entity.User;
import com.example.blog.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
	private IUserService userService;
	@Test
	void contextLoads() {

		ArrayList<User> users = new ArrayList<>();
		//test of adding 50 random users
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setUserName(i + "uName");
			user.setUserPassword(SecureUtil.md5("123456"));
			user.setUserFrozen(0);
			user.setUserRegisterTime(DateUtil.date());
			users.add(user);
		}

		userService.saveBatch(users, 50);
	}

}
