package com.gj1913894.web.starter.ctrl;

import com.gj1913894.web.starter.dto.UserRegisterDto;
import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author 孙权
 */
@RestController
@RequestMapping("api/user")
public class UserCtrl {

	@Autowired
	private UserService userService;

	@RequestMapping("login")
	public User login(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
			System.out.println(stringEntry.getKey() + Arrays.toString(stringEntry.getValue()));
		}
		Date date = new Date();
		User user = new User();
		user.setDate(date);
		return user;
	}

	@GetMapping("register")
	public void register(@Valid UserRegisterDto userRegisterDto) {
		userService.register(userRegisterDto);
	}
}
