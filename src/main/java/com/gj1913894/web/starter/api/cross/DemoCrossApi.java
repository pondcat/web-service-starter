package com.gj1913894.web.starter.api.cross;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author gejian
 */
@RestController
@RequestMapping("/api/inner/demo")
public class DemoCrossApi {
	@GetMapping
	public String demo() {
		return LocalDateTime.now().toString();
	}
}
