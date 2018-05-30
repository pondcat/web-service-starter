package com.gj1913894.web.starter.service;

import com.gj1913894.web.starter.entity.DbEntity;
import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gejian
 */
@Service
public class DemoService implements Serializable {
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") @Autowired private UserMapper userMapper;

	@Transactional
	public LocalDateTime serve() {
		User user = new User();
		user.setMobile("13712345678");
		user.setRealName("lis");
		user.setStat("normal");
		userMapper.insert(user);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				user.setId(null);
				userMapper.insert(user);
			}
		});
		BeanCopier beanCopier = BeanCopier.create(User.class, DbEntity.class, true);

		return LocalDateTime.now();
	}

}
