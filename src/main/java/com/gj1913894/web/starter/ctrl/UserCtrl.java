package com.gj1913894.web.starter.ctrl;

import com.alibaba.fastjson.JSON;
import com.gj1913894.web.starter.dto.CqSsc;
import com.gj1913894.web.starter.dto.UserDto;
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

import java.util.Date;

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

    @GetMapping("login")
    public String login() {
        UserDto userDto = new UserDto();
        userDto.setId(22);
        userDto.setUsername("lisi");
        userDto.setMobile("136123456");
        userDto.setCreateTime(new Date());
        SscService sscService = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(SscService.class, "http://f.apiplus.net");
        CqSsc cqssc = sscService.cqssc();
        return JSON.toJSONString(cqssc);
//        return "ss";
    }
}
