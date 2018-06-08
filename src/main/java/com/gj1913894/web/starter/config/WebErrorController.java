package com.gj1913894.web.starter.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pondcat.commons.combine.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring version2.0.2版, 打开WebMvcEndpointHandlerMapping,
 * ControllerEndpointHandlerMapping的debug级别日志时, 会打印Did not find handler method for
 * [/error], 这是正常现象, 不用理会
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class WebErrorController implements ErrorController {

	private final ServerProperties serverProperties;

	public WebErrorController(ServerProperties serverProperties) {
		this.serverProperties = serverProperties;
	}

	@Override
	public String getErrorPath() {
		return this.serverProperties.getError().getPath();
	}

	@RequestMapping
	@ResponseBody
	public Result<Void> error(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request);
		System.out.println(response);
		System.out.println(response.getStatus());
		return Result.error("");
	}

}
