package com.gj1913894.web.starter.config;

import com.gj1913894.web.starter.dto.Result;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gejian
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
