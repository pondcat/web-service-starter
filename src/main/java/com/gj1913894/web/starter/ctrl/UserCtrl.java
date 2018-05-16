package com.gj1913894.web.starter.ctrl;

import com.gj1913894.web.starter.dto.UserRegisterDto;
import com.gj1913894.web.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 孙权
 */
@RestController
@RequestMapping("user")
public class UserCtrl {

	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String login() {
		return null;
	}

	@GetMapping("register")
	public void register(@Valid UserRegisterDto userRegisterDto) {
		userService.register(userRegisterDto);
	}
}
