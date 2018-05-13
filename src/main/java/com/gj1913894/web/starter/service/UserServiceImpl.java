package com.gj1913894.web.starter.service;

import com.gj1913894.web.starter.dto.UserRegisterDto;
import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.exception.BusinessOutException;
import com.gj1913894.web.starter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserMapper userMapper;

	@Override
	public void register(UserRegisterDto userRegisterDto) throws BusinessOutException {
		// todo 校验手机验证码
		String mobile = userRegisterDto.getMobile();
		boolean b = userMapper.existsByMobile(mobile);
		Assert.isTrue(!b, "手机号已注册");
		// 注册
		User user = new User();
		user.setMobile(mobile);
		String username = userRegisterDto.getUsername();
		user.setUsername(username == null ? randomUsername() : username);
		userMapper.insert(user);
	}

	private String randomUsername() {
		// todo 无用户名时, 生成随机用户名
		return "";
	}

}
