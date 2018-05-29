package com.gj1913894.web.starter.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.gj1913894.web.starter.mapper.DemoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gejian
 */
@EnableTransactionManagement
@Configuration
@MapperScan(basePackageClasses = DemoMapper.class)
public class MybatisPlusConfig {
	/**
	 * 分页插件，自动识别数据库类型
	 *
	 * @return 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

}