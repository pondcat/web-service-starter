package com.gj1913894.web.starter;

import com.gj1913894.web.starter.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gejian
 */
@MapperScan(basePackageClasses = UserMapper.class)
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class WebServiceStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceStarterApplication.class, args);
	}

}
