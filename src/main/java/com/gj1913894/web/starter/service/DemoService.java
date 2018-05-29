package com.gj1913894.web.starter.service;

import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author gejian
 */
@Service
public class DemoService implements Serializable {
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Autowired private UserMapper userMapper;

	public LocalDateTime serve() {
		List<User> users = userMapper.selectAll();
		System.out.println(users);
		return LocalDateTime.now();
	}
}
