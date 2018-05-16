package com.gj1913894.web.starter;

import com.gj1913894.web.starter.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * @author gejian
 */
@MapperScan(basePackageClasses = UserMapper.class)
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class WebServiceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceStarterApplication.class, args);
	}

}
