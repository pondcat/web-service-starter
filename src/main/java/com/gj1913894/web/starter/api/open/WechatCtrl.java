package com.gj1913894.web.starter.api.open;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/open/wechat")
public class WechatCtrl {
	/**
	 * 微信 基本配置 -> 服务器配置 验证
	 *
	 * @return
	 */
	@GetMapping("serverVerify")
	public String serverVerify(String signature, String timestamp, String nonce, String echostr) {
		// 明文模式
		return echostr;
	}
}
