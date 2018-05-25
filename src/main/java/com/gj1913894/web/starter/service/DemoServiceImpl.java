package com.gj1913894.web.starter.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gejian
 */
@Service
public class DemoServiceImpl implements DemoService {
	@Override
	public LocalDateTime serve() {
		return LocalDateTime.now();
	}
}
