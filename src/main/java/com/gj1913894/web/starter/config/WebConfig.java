package com.gj1913894.web.starter.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author gejian at 2018/5/13 23:46
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		Iterator<HttpMessageConverter<?>> it = converters.iterator();
		while (it.hasNext()) {
			HttpMessageConverter<?> next = it.next();
			String name = next.getClass().getName();
			if (name.startsWith("xml.MappingJackson", "org.springframework.http.converter.".length())
					|| name.startsWith("json.MappingJackson", "org.springframework.http.converter.".length())) {
				it.remove();
			}
		}
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON, new MediaType("application", "*+json")));
		converters.add(0, converter);
	}
}
