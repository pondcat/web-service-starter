package com.gj1913894.web.starter.ctrl;

import com.alibaba.fastjson.JSON;
import com.gj1913894.web.starter.dto.CqSsc;
import com.gj1913894.web.starter.dto.UserRegisterDto;
import com.gj1913894.web.starter.service.UserService;
import com.gj1913894.web.starter.service.third.SscService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 孙权
 */
@RestController
@RequestMapping("user")
public class UserCtrl {
	/*@Autowired
	private RestTemplate converter;*/
	@Autowired
	private Decoder decoder;

	@Autowired
	private Encoder encoder;

	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String login() {
		SscService sscService = Feign.builder()
				.encoder(encoder)
				.decoder(decoder)
				.options(new Request.Options(1000, 3500))
				.retryer(new Retryer.Default(5000, 5000, 3))
				.target(SscService.class, "http://f.apiplus.net");
		CqSsc cqssc = sscService.cqssc();
		return JSON.toJSONString(cqssc);
	}

	@GetMapping("register")
	public void register(@Valid UserRegisterDto userRegisterDto) {
		userService.register(userRegisterDto);
	}
}
