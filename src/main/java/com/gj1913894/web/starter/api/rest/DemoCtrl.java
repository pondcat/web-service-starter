package com.gj1913894.web.starter.api.rest;

import com.gj1913894.web.starter.dto.Result;
import com.gj1913894.web.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author gejian
 */
@RestController
@RequestMapping("/api/rest/demo")
public class DemoCtrl {
	private @Autowired DemoService demoService;

	@GetMapping("ss")
	public Result<String> demo() {
		return Result.ok(LocalDateTime.now().toString());
	}

	@GetMapping("{id}/ss")
	public Result<String> demo1(@PathVariable Integer id) {
		return Result.ok(LocalDateTime.now().toString());
	}

	@GetMapping("serve")
	public Result<String> serve() {
		LocalDateTime dateTime = demoService.serve();
		return Result.ok(dateTime.toString());
	}
}
