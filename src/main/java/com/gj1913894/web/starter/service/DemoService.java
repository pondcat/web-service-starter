package com.gj1913894.web.starter.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gejian
 */
@Service
public class DemoService {
	public LocalDateTime serve() {
		return LocalDateTime.now();
	}
}
