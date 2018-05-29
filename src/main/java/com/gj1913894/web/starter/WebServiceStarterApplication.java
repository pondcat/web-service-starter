package com.gj1913894.web.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gejian
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.gj1913894.web.starter.mapper")
@SpringBootApplication
public class WebServiceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceStarterApplication.class, args);
	}

}
