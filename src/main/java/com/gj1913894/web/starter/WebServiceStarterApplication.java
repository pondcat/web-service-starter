package com.gj1913894.web.starter;

import com.gj1913894.web.starter.mapper.DemoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gejian
 */
@MapperScan(basePackageClasses = DemoMapper.class)
@SpringBootApplication
public class WebServiceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceStarterApplication.class, args);
	}

}
