package com.gj1913894.web.starter.config;

import com.alibaba.fastjson.JSON;
import com.gj1913894.web.starter.service.http.SscService;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * @author gejian
 */
@Configuration
@ConfigurationProperties(prefix = "feign.client.scan")
public class FeignConfig {
	private final Request.Options defaultRequestOptions = new Request.Options(1000, 3500);

	private final Retryer.Default defaultRetryer = new Retryer.Default(5000, 5000, 3);

	private String pkg;

	private Encoder feignEncoder = (object, bodyType, template) -> {
		if (bodyType == String.class) {
			template.body(object.toString());
		}
		else if (bodyType == byte[].class) {
			template.body((byte[]) object, null);
		}
		else {
			template.body(JSON.toJSONBytes(object), StandardCharsets.UTF_8);
		}
	};

	private Decoder feignDecoder = (response, type) -> {
		if (response.status() == 404) {
			return Util.emptyValueOf(type);
		}
		Response.Body body = response.body();
		if (body == null) {
			return null;
		}
		else if (byte[].class.equals(type)) {
			return Util.toByteArray(body.asInputStream());
		}
		else if (String.class.equals(type)) {
			return Util.toString(body.asReader());
		}
		else {
			return JSON.parseObject(body.asInputStream(), type);
		}
	};

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	@Bean
	SscService sscService() {
		Class<SscService> returnType = SscService.class;
		String url = "http://f.apiplus.net";
		return defaultBuilder(returnType, url);
	}

	private <T> T defaultBuilder(Class<T> returnType, String url) {
		return Feign.builder()
				.logger(new Slf4jLogger(returnType))
				.encoder(feignEncoder)
				.decoder(feignDecoder)
				.options(defaultRequestOptions)
				.retryer(defaultRetryer)
				.target(returnType, url);
	}

}
