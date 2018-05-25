package com.gj1913894.web.starter.api.open;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author gejian at 2018/5/22 8:44
 */
@RestController
@RequestMapping("/api/open/demo")
public class DemoOpenApi {
	@GetMapping
	public String demo() {
		return LocalDateTime.now().toString();
	}
}
