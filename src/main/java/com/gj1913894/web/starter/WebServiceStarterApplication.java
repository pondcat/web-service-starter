package com.gj1913894.web.starter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@SpringBootApplication
//@EnableFeignClients
public class WebServiceStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceStarterApplication.class, args);
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON, new MediaType("application", "*+json")));
        return converter;
    }

    /*@Bean
    public RestTemplate restTemplate(FastJsonHttpMessageConverter messageConverter) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> it = messageConverters.iterator();
        while (it.hasNext()) {
            HttpMessageConverter<?> next = it.next();
            String name = next.getClass().getName();
            if (name.startsWith("xml.MappingJackson", "org.springframework.http.converter.".length())
                    || name.startsWith("json.MappingJackson", "org.springframework.http.converter.".length())) {
                it.remove();
            }
        }
        messageConverters.add(0, messageConverter);
        return restTemplate;
    }*/

    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            if (response.status() == 404) {
                return Util.emptyValueOf(type);
            }
            Response.Body body = response.body();
            if (body == null) {
                return null;
            } else if (byte[].class.equals(type)) {
                return Util.toByteArray(body.asInputStream());
            } else if (String.class.equals(type)) {
                return Util.toString(body.asReader());
            } else {
                return JSON.parseObject(body.asInputStream(), type);
            }
        };
    }

    @Bean
    public Encoder feignEncoder() {
        return (object, bodyType, template) -> {
            if (bodyType == String.class) {
                template.body(object.toString());
            } else if (bodyType == byte[].class) {
                template.body((byte[]) object, null);
            } else {
                template.body(JSON.toJSONBytes(object), StandardCharsets.UTF_8);
            }
        };
    }
}