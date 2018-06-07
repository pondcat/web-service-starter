package com.gj1913894.web.starter.service;

import com.gj1913894.web.starter.dao.UserMapper;
import com.gj1913894.web.starter.dto.Student;
import com.gj1913894.web.starter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gejian
 */
@Service
public class DemoService implements Serializable {
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Autowired private UserMapper userMapper;

	@Transactional
	public LocalDateTime serve(@Validated User user1) {
		Student user = new Student();
		user.setMobile("13712345678");
		user.setRealName("lis");
		user.setStat("normal");
		user.setRole("r");
		user.setGrade("4");
		user.setCtime(LocalDateTime.now());
		userMapper.insert(user);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				user.setId(null);
				userMapper.insert(user);
			}
		});

		return LocalDateTime.now();
	}

}
