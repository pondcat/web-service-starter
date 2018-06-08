package com.gj1913894.web.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author gejian
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.gj1913894.web.starter.dao")
@SpringBootApplication
@ServletComponentScan({"com.gj1913894.web.starter.filter",
		"com.gj1913894.web.starter.listener"})
public class WebServiceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceStarterApplication.class, args);
	}

}
